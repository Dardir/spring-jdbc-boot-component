package training.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import training.common.CSVGenerator;
import training.dao.PrevMaintDAO;
import training.dto.PrevMaint;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class RestInterceptor implements BEAPI {

    @Autowired
    PrevMaintDAO prevMaintDAO;

    @RequestMapping("/getPrevMaint")
    @PreAuthorize("hasRole('MAINT_USER')")
    public List<PrevMaint> getAllTrainingsByRole(@RequestParam(value="eqinstId") String eqinstId) {
         return prevMaintDAO.getPrevMaintByEqInstId(eqinstId);
    }

    @RequestMapping(value = "/exportToCsv", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> exportToCsv(@RequestBody String jsonStr){

        try {
            String result = CSVGenerator.generateCSV(jsonStr,',',"_");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error Message: "+e.getMessage());
        }

    }
}

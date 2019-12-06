package training.dao;

import training.dto.PrevMaint;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class PrevMaintDAO {

    @Autowired
    private JdbcTemplate theTemplate;

    public  List<PrevMaint> getPrevMaintByEqInstId(String eqInsId){
        List<PrevMaint> prevMaints = theTemplate.query("select * from prev_maint where eq_ins_id =?",
                new Object[]{eqInsId}, (resultSet, i) -> {
                    return toPrevMaint(resultSet,i);
                });;
        if(prevMaints != null && prevMaints.size()> 0){
            return prevMaints;
        }
        return null;
    }

    private PrevMaint toPrevMaint(ResultSet resultSet, int index) throws SQLException {
        return new PrevMaint(index,resultSet.getString("location"),resultSet.getDate("maint_date"),resultSet.getString("notes"));
    }

}

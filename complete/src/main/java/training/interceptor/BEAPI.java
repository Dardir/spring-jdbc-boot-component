package training.interceptor;

import training.dto.PrevMaint;

import java.util.List;

public interface BEAPI {
    public List<PrevMaint> getAllTrainingsByRole(String roleName);
}

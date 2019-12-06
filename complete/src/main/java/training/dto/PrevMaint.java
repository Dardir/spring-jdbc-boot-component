package training.dto;

import java.sql.Date;

public class PrevMaint {

    private final long prevMaintId;
    private final String location;
    private final Date maintDate;
    private final String notes;

    public PrevMaint(long prevMaintId, String location, Date maintDate, String notes) {
        this.prevMaintId = prevMaintId;
        this.location = location;
        this.maintDate = maintDate;
        this.notes = notes;
    }

    public Date getMaintDate() {
        return maintDate;
    }

    public String getNotes() {
        return notes;
    }

    public long getPrevMaintId() {
        return prevMaintId;
    }

    public String getLocation() {
        return location;
    }
}

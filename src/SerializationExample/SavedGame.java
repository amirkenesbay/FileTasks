package SerializationExample;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

public class SavedGame implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String[] territoriesInfo;
    private String[] resourceInfo;
    private String[] diplomacyInfo;

    public SavedGame(String[] territoriesInfo, String[] resourceInfo, String[] diplomacyInfo) {
        this.territoriesInfo = territoriesInfo;
        this.resourceInfo = resourceInfo;
        this.diplomacyInfo = diplomacyInfo;
    }

    public String[] getTerritoriesInfo() {
        return territoriesInfo;
    }

    public void setTerritoriesInfo(String[] territoriesInfo) {
        this.territoriesInfo = territoriesInfo;
    }

    public String[] getResourceInfo() {
        return resourceInfo;
    }

    public void setResourceInfo(String[] resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    public String[] getDiplomacyInfo() {
        return diplomacyInfo;
    }

    public void setDiplomacyInfo(String[] diplomacyInfo) {
        this.diplomacyInfo = diplomacyInfo;
    }

    @Override
    public String toString() {
        return "SavedGame{" +
                "territoriesInfo=" + Arrays.toString(territoriesInfo) +
                ", resourceInfo=" + Arrays.toString(resourceInfo) +
                ", diplomacyInfo=" + Arrays.toString(diplomacyInfo) +
                '}';
    }
}

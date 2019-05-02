public class ResponseClass {

    Boolean nameCheck;
    Boolean registerationNumberCheck;
    Boolean dateOfEstablishmentCheck;

    public boolean isNameCheck() {
        return nameCheck;
    }

    public void setNameCheck(boolean nameCheck) {
        this.nameCheck = nameCheck;
    }

    public boolean isRegisterationNumberCheck() {
        return registerationNumberCheck;
    }

    public void setRegisterationNumberCheck(boolean registerationNumberCheck) {
        this.registerationNumberCheck = registerationNumberCheck;
    }

    public boolean isdateOfEstablishmentCheck() {
        return dateOfEstablishmentCheck;
    }

    public void setdateOfEstablishmentCheck(boolean dateOfEstablishmentCheck) {
        this.dateOfEstablishmentCheck = dateOfEstablishmentCheck;
    }

    public ResponseClass(Boolean nameCheck, Boolean registerationNumberCheck, Boolean dateOfEstablishmentCheck) {
        this.nameCheck = nameCheck;
        this.registerationNumberCheck = registerationNumberCheck;
        this.dateOfEstablishmentCheck = dateOfEstablishmentCheck;
    }
}

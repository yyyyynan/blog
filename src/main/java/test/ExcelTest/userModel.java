package test.ExcelTest;

/**
 * @author Administrator
 */
public class userModel {
    private int userId;
    private String groupType;
    private String unit;
    private String name;
    private int gender;
    private String birthData;
    private String jobName;
    private String education;
    private String professional;
    private String currentlyProfessional;
    private String businessExpertise;
    private String telephone;
    private String mobilePhone;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthData() {
        return birthData;
    }

    public void setBirthData(String birthData) {
        this.birthData = birthData;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getCurrentlyProfessional() {
        return currentlyProfessional;
    }

    public void setCurrentlyProfessional(String currentlyProfessional) {
        this.currentlyProfessional = currentlyProfessional;
    }

    public String getBusinessExpertise() {
        return businessExpertise;
    }

    public void setBusinessExpertise(String businessExpertise) {
        this.businessExpertise = businessExpertise;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }


    @Override
    public String toString() {
        return "userModel{" +
                "userId=" + userId +
                ", groupType='" + groupType + '\'' +
                ", unit='" + unit + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthData='" + birthData + '\'' +
                ", jobName='" + jobName + '\'' +
                ", education='" + education + '\'' +
                ", professional='" + professional + '\'' +
                ", currentlyProfessional='" + currentlyProfessional + '\'' +
                ", businessExpertise='" + businessExpertise + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }

    public boolean noHaveEmpty() {
        if (groupType != null
                && unit != null
                && name != null
                && gender != 0
                && birthData != null
                && jobName != null
                && education != null
                && professional != null
                && currentlyProfessional != null
                && businessExpertise != null
                && telephone != null
                && mobilePhone != null
        ) {
            return true;
        }
        return false;
    }
}

package com.muhib.ninetydegree.webapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Set;

public class SharedPrefsHandler {
    private SharedPreferences sharedPrefs;

    public SharedPrefsHandler(Context context) {
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /* After Registration, Passenger will enter activation code,
     * if passenger stay in EnterActivationCodeActivity then it return true
     * otherwise will be false
     */
    public int getEzzyrMessageCount(){
        return sharedPrefs.getInt("ezzyr_message_count",0);
    }

    public void getDeleteEzzyrMessageCount() {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.remove("ezzyr_message_count").apply();
    }

    public void setEzzyrMessageCount(int count){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        if(editor ==null)
            editor = sharedPrefs.edit();
        editor.putInt("ezzyr_message_count",count);
        editor.apply();
    }

    public String getFCMRegistrationID() {
        return sharedPrefs.getString("fcm_registration_id", null);
    }

    public String getNotificationKEY() {
        return sharedPrefs.getString("notification_key", null);
    }
    public void setNotificationKEY(String notificationKEY) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("notification_key", notificationKEY);
        editor.apply();
    }
    public String getValueNotificationKEY() {
        return sharedPrefs.getString("valueNotificationKEY", null);
    }
    public void setValueNotificationKEY(String valueNotificationKEY) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("valueNotificationKEY", valueNotificationKEY);
        editor.apply();
    }

    public String getVersionId() {
        return sharedPrefs.getString("version_id", null);
    }

    public void setVersionId(String versionId) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("version_id", versionId);
        editor.apply();
    }

    public void setFCMRegistrationID(String regID) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("fcm_registration_id", regID);
        editor.apply();
    }

    public void clear() {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.clear();
        editor.apply();
    }

    public String getOauthToken() {
        return sharedPrefs.getString("token", null);
    }




    public String getFullName() {
        return sharedPrefs.getString("full_name", "");
    }

    public void setFullName(String fullName) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("full_name", fullName);
        editor.apply();
    }






    public String getMemberID() {
        return sharedPrefs.getString("member_id", null);
    }

    public void setMemberID(String memberID) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("member_id", memberID);
        editor.apply();
    }




    public String getMobileNo() {
        return sharedPrefs.getString("mobile_no", null);
    }

    public void setMobileNo(String mobileNo) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("mobile_no", mobileNo);
        editor.apply();
    }

    /* share friend to free rides*/
    public String getReferelCOde() {
        return sharedPrefs.getString("referel_code", null);
    }

    public void setReferelCOde(String mobileNo) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("referel_code", mobileNo);
        editor.apply();
    }

    public String getProfileImageUrl() {
        return sharedPrefs.getString("profilepicUrl", null);
    }

    public void setProfileImageUrl(String profileImageUrl) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("profilepicUrl", profileImageUrl);
        editor.apply();

    }

    public String getEmail() {
        return sharedPrefs.getString("email", null);
    }

    public void setEmail(String email) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("email", email);
        editor.apply();
    }

    public String getPassword() {
        return sharedPrefs.getString("password", null);
    }

    public void setPassword(String password) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("password", password);
        editor.apply();
    }

    public void setflagId(int flagId) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("flagId", flagId);
        editor.apply();
    }

    public int getflagId() {
        return sharedPrefs.getInt("flagId", 0);
    }

    public String getChannel() {
        return sharedPrefs.getString("channel", null);
    }

    public void setChannel(String channelName) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("channel", channelName);
        editor.apply();
    }

   /* public void setProfileInfo(String token, String memberID, String userID, String password, String fullName, String mobileNo, String email, String proPicURl) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        if (token != null)
            editor.putString("mobile_token", token);
        if (fullName != null)
            editor.putString("full_name", fullName);
        if (userID != null)
            editor.putString("user_id", userID);
        if (memberID != null)
            editor.putString("member_id", memberID);
        if (mobileNo != null)
            editor.putString("mobile_no", mobileNo);
        if (password != null)
            editor.putString("password", password);
        if (email != null)
            editor.putString("email", email);
        if (proPicURl != null)
            editor.putString("profile_pic_url", proPicURl);

        editor.apply();
    }*/
    public void setDeviceInfo(int id, String deviceId, String userID, int status) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        if (id != 0)
            editor.putInt("id", id);
        if (deviceId != null)
            editor.putString("deviceId", deviceId);
        if (userID != null)
            editor.putString("user_id", userID);
        if (status != 0)
            editor.putInt("status", status);
        editor.apply();
    }

    public int getDeviceStatus(){
        return sharedPrefs.getInt("status", 0);
    }
    public int getId1(){
        return sharedPrefs.getInt("id", 0);
    }

    public String getDeviceId() {
        return sharedPrefs.getString("deviceId", null);
    }

    public void setLoginInfo(String token, String member_type, String email, String mobileNo, String member_id, String firstName, String lastName, String proPicURl, String designation, String organization, int user_id) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("token", token);
        editor.putString("member_type", member_type);
        editor.putString("email", email);
        editor.putString("mobile_no", mobileNo);
        editor.putString("member_id", member_id);
        editor.putString("first_name", firstName);
        editor.putString("last_name", lastName);
        editor.putString("profile_pic_url", proPicURl);
        editor.putString("designation", designation);
        editor.putString("organization", organization);
        editor.putInt("userid", user_id);
        editor.apply();
    }

    public String getFirstName() {
        return sharedPrefs.getString("first_name", null);
    }
  public int getUserIntID() {
        return sharedPrefs.getInt("userid", 0);
    }

    public String getLastName() {
        return sharedPrefs.getString("last_name", null);
    }

    public String getMemberType() {
        return sharedPrefs.getString("member_type", null);
    }

    public String getDestination() {
        return sharedPrefs.getString("designation", null);
    }

    public String getOrganization() {
        return sharedPrefs.getString("organization", null);
    }

    public void setMerchantLoginInfo(String token, String memberID, String userID, String password, String fullName, String mobileNo, String email, String proPicURl) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("mobile_token", token);
        editor.putString("full_name", fullName);
        editor.putString("user_id", userID);
        editor.putString("member_id", memberID);
        editor.putString("mobile_no", mobileNo);
        editor.putString("password", password);
        editor.putString("email", email);
        editor.putString("profile_pic_url", proPicURl);
        editor.apply();
    }

    public void setForgetLoginInfo(String token, String memberID, String userID, String fullName, String mobileNo, String email, String proPicURl, int zoneId) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("mobile_token", token);
        editor.putString("full_name", fullName);
        editor.putString("user_id", userID);
        editor.putString("member_id", memberID);
        editor.putString("mobile_no", mobileNo);
        editor.putString("email", email);
        editor.putString("profile_pic_url", proPicURl);
        editor.putInt("zone_id", zoneId);
        editor.apply();
    }

    public String getMemberProfilePicURl() {
        return sharedPrefs.getString("profile_pic_url", null);
    }

    public Set<String> getList() {
        return sharedPrefs.getStringSet("dataList", null);
    }

    public void setList(Set<String> data) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putStringSet("dataList", data);
        editor.apply();
    }

    public int getSize() {
        return sharedPrefs.getInt("size", 0);
    }

    public void setSize(int size) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("size", size);
        editor.apply();
    }

    public String getDeliveryApiId() {
        return sharedPrefs.getString("deliveryApiId", null);
    }

    public void setDeliveryApiId(String deliveryApiId) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("deliveryApiId", deliveryApiId);
        editor.apply();
    }

    public void setRatingValue(double ratingValue) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putFloat("rating_value", (float) ratingValue);
        editor.apply();
    }

    public int getTripCount() {
        return sharedPrefs.getInt("trip_count", 0);
    }

    public void setTripCount(int tripCount) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("trip_count", tripCount);
        editor.apply();
    }

    public float getRatingvalue() {
        return sharedPrefs.getFloat("rating_value", 1f);
    }

    public void setProfileInfo(String memberID, int userID, String fullName, String mobileNo, String email) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("full_name", fullName);
        editor.putInt("userid", userID);
        editor.putString("member_id", memberID);
        editor.putString("mobile_no", mobileNo);
        editor.putString("email", email);
        editor.apply();
    }

    public void setpickupdash(int todaysPickup, int todaysVisit, int todaysQuantity, int todaysReceived, int todaysPending) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("todaysPickup", todaysPickup);
        editor.putInt("todaysVisit", todaysVisit);
        editor.putInt("todaysQuantity", todaysQuantity);
        editor.putInt("todaysReceived", todaysReceived);
        editor.putInt("todaysPending", todaysPending);
        editor.apply();
    }

    public void setDeliveryupdash(int todaysCollected, int todaysVisited, int todaysReturn, int todaysOnHold, int todaysDelivery, int collectedAmount) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("todaysCollected", todaysCollected);
        editor.putInt("todaysVisited", todaysVisited);
        editor.putInt("todaysReturn", todaysReturn);
        editor.putInt("todaysOnHold", todaysOnHold);
        editor.putInt("todaysDelivery", todaysDelivery);
        editor.putInt("collectedAmount", collectedAmount);
        editor.apply();
    }

    public int getTodaysPickup() {
        return sharedPrefs.getInt("todaysPickup", 0);
    }

    public int getTodaysCollected() {
        return sharedPrefs.getInt("todaysCollected", 0);
    }

    public int getTodaysReturn() {
        return sharedPrefs.getInt("todaysReturn", 0);
    }

    public int getTodaysOnHold() {
        return sharedPrefs.getInt("todaysOnHold", 0);
    }

    public int getTodaysDelivery() {
        return sharedPrefs.getInt("todaysDelivery", 0);
    }

    public int getcollectedAmount() {
        return sharedPrefs.getInt("collectedAmount", 0);
    }

    public int getTodaysVisit() {
        return sharedPrefs.getInt("todaysVisit", 0);
    }

    public int getTodaysVisited() {
        return sharedPrefs.getInt("todaysVisited", 0);
    }

    public int getTodaysQuantity() {
        return sharedPrefs.getInt("todaysQuantity", 0);
    }

    public int getTodaysReceived() {
        return sharedPrefs.getInt("todaysReceived", 0);

    }

    public int getTodaysPending() {
        return sharedPrefs.getInt("todaysPending", 0);

    }

    public void setActiveVehicleInfo(int carID, int carType, String plateNO, String carName) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("vehicle_id", carID);
        editor.putInt("car_type", carType);
        editor.putString("car_plate_no", plateNO);
        editor.putString("car_name", carName);
        editor.apply();
    }

    public void setDocInfo(boolean nidFront, boolean nidBack, boolean passportPage1, boolean passportPage2, boolean drivingLicense, boolean registration, boolean taxtoken, boolean fitness, boolean insurance) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("nid_front", nidFront);
        editor.putBoolean("nid_back", nidBack);
        editor.putBoolean("passport_page1", passportPage1);
        editor.putBoolean("passport_page2", passportPage2);
        editor.putBoolean("driving_license", drivingLicense);
        editor.putBoolean("registration", registration);
        editor.putBoolean("tax_token", taxtoken);
        editor.putBoolean("fitness", fitness);
        editor.putBoolean("insurance", insurance);
        editor.apply();
    }

    public String getHomePageDelivery() {
        return sharedPrefs.getString("delivery", null);
    }

    public void setHomePageDelivery(String deliveryId) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("delivery", deliveryId);
        editor.apply();
    }

    public String getHomePagePickup() {
        return sharedPrefs.getString("pickup", null);
    }

    public void setHomePagePickup(String pickupId) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("pickup", pickupId);
        editor.apply();
    }

    public boolean isNidFrontUploaded() {
        return sharedPrefs.getBoolean("nid_front", false);
    }

    public boolean isNidBackUploaded() {
        return sharedPrefs.getBoolean("nid_back", false);
    }

    public boolean isPassportPage1Uploaded() {
        return sharedPrefs.getBoolean("passport_page1", false);
    }

    public boolean isPassportPage2Uploaded() {
        return sharedPrefs.getBoolean("passport_page2", false);
    }

    public boolean isDrivingLicenseUploaded() {
        return sharedPrefs.getBoolean("driving_license", false);
    }

    public boolean isRegistrationUploaded() {
        return sharedPrefs.getBoolean("registration", false);
    }

    public boolean isTaxTokenUploaded() {
        return sharedPrefs.getBoolean("tax_token", false);
    }

    public boolean isFitnessUploaded() {
        return sharedPrefs.getBoolean("fitness", false);
    }

    public boolean isInsuranceUploaded() {
        return sharedPrefs.getBoolean("insurance", false);
    }

    public void setMerchantInfo(boolean isMerchant, boolean hasMerchant, String merchantName, String mobileNoMerchant, String merchantLastName) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("is_merchant", isMerchant);
        editor.putBoolean("has_merchant", hasMerchant);
        editor.putString("merchant_name", merchantName);
        editor.putString("mobile_no_merchant", mobileNoMerchant);
        editor.putString("last_name", merchantLastName);
        editor.apply();
    }

    public void setMerchantFirstName(String name) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("merchant_name", name);
        editor.apply();
    }

    public void setMerchantPhoneNumber(String phone) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("mobile_no_merchant", phone);
        editor.apply();
    }

    public boolean isMerchant() {
        return sharedPrefs.getBoolean("is_merchant", false);
    }

    public boolean hasMerchant() {
        return sharedPrefs.getBoolean("has_merchant", false);
    }

    public String getMerchantName() {
        return sharedPrefs.getString("merchant_name", "");
    }

    public String getMobileNoMerchant() {
        return sharedPrefs.getString("mobile_no_merchant", "");
    }

    public String getMerchantLastName() {
        return sharedPrefs.getString("last_name", "");
    }

    public void setMerchantLastName(String name) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("last_name", name);
        editor.apply();
    }

    public int getVehicleId() {
        return sharedPrefs.getInt("vehicle_id", 0);
    }

    public void setVehicleId(int vehicleId) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("vehicle_id", vehicleId);
        editor.apply();
    }

    /* 3types Car, Bike, Ambulance*/
  /*  public int getCarType(){
        return sharedPrefs.getInt("car_type",StaticValue.CAR);
    }
    public void setCarType(int carType){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("car_type",carType);
        editor.apply();
    }



    public void setMemberProfilePicURl(String url){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("profile_pic_url",url);
        editor.apply();
    }

    public String getCarPlateNo(){
        return sharedPrefs.getString("car_plate_no","");
    }
    public void setCarPlateNo(String carPlateNo){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("car_plate_no",carPlateNo);
        editor.apply();
    }
    public String getCarName(){
        return sharedPrefs.getString("car_name","");
    }

    public void setCarName(String carName){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("car_name",carName);
        editor.apply();
    }

    public boolean isAcceptTrip(){
        return sharedPrefs.getBoolean("accept_trip",false);
    }

    public void setAcceptTrip(boolean acceptTrip){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("accept_trip",acceptTrip);
        editor.apply();
    }

    public long getTripStartTime(){
        return sharedPrefs.getLong("trip_start_time",00);
    }

    public void setTripStartTime(long tripStartTime){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putLong("trip_start_time",tripStartTime);
        editor.apply();
    }*/

    /* is driver app online or not */
    public boolean isOnLine() {
        return sharedPrefs.getBoolean("on_line", true);
    }

    public void setOnLine(boolean onLine) { // false means offline true means online
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("on_line", onLine);
        editor.apply();
    }

    /* Check if the service is still activated by the user */
   /* public boolean isServiceRunning(){
        return sharedPrefs.getBoolean(Constants.SERVICE_RUNNING,false);
    }

    public void setServiceRunning(boolean isRunning){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean(Constants.SERVICE_RUNNING,isRunning);
        editor.apply();
    }

     Get the update frequency
    public int getUpdateFrequency(){
        return sharedPrefs.getInt(Constants.PUSH_TIME,4);
    }

    public void setUpdateFrequency(int updateFrequency){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt(Constants.PUSH_TIME,updateFrequency);
        editor.apply();
    }*/
    public boolean isDrivingON() {
        return sharedPrefs.getBoolean("driving_on", false);
    }

    public void setDrivingON(boolean driverON) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("driving_on", driverON);
        editor.apply();
    }

    public boolean isStopNewRequest() {
        return sharedPrefs.getBoolean("stop_new_request", false);
    }

    public void setStopNewRequest(boolean stopNewRequest) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("stop_new_request", stopNewRequest);
        editor.apply();
    }

    public boolean isDoneSignUp() {
        return sharedPrefs.getBoolean("all_done_sign_up", false);
    }

    // all done sign up
    public void setDoneSignUp(boolean flag) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("all_done_sign_up", flag);
        editor.apply();
    }

    public boolean isVarified() {
        return sharedPrefs.getBoolean("varified", false);
    }

    public void setVarified(boolean flag) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("varified", flag);
        editor.apply();
    }

    public boolean isContinueDone() {
        return sharedPrefs.getBoolean("continue_sign_up", false);
    }

    public void setContinueDone(boolean flag) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("continue_sign_up", flag);
        editor.apply();
    }

    public boolean isAcceptDone() {
        return sharedPrefs.getBoolean("accept_sign_up", false);
    }

    public void setAcceptDone(boolean flag) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("accept_sign_up", flag);
        editor.apply();
    }

    public boolean isUploadAllDocuments() {
        return sharedPrefs.getBoolean("all_upload_docs_sign_up", false);
    }

    public void setUploadAllDocuments(boolean flag) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("all_upload_docs_sign_up", flag);
        editor.apply();
    }

    public boolean isNIDDone() {
        return sharedPrefs.getBoolean("nid_sign_up", false);
    }

    public void setNIDDone(boolean flag) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("nid_sign_up", flag);
        editor.apply();
    }

    public boolean isDriverLicenseDone() {
        return sharedPrefs.getBoolean("d_license_sign_up", false);
    }

    public void setDriverLicenseDone(boolean flag) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("d_license_sign_up", flag);
        editor.apply();
    }

    public boolean isFitnessCertDone() {
        return sharedPrefs.getBoolean("fitness_cert_sign_up", false);
    }

    public void setFitnessCertDone(boolean flag) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("fitness_cert_sign_up", flag);
        editor.apply();
    }

    public boolean isTaxTokenDone() {
        return sharedPrefs.getBoolean("tax_token_sign_up", false);
    }

    public void setTaxTokenDone(boolean flag) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("tax_token_sign_up", flag);
        editor.apply();
    }

    public boolean isInsuranceDone() {
        return sharedPrefs.getBoolean("insurance_sign_up", false);
    }

    public void setInsuranceDone(boolean flag) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("insurance_sign_up", flag);
        editor.apply();
    }

    public void setRegistrationDone(boolean flag) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("registration_cert_sign_up", flag);
        editor.apply();
    }

    public boolean istRegistrationDone() {
        return sharedPrefs.getBoolean("registration_cert_sign_up", false);
    }

    public void setProfilePicUploadDone(boolean flag) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("profile_pic_sign_up", flag);
        editor.apply();
    }

    public boolean istProfilePicUploadDone() {
        return sharedPrefs.getBoolean("profile_pic_sign_up", false);
    }

    public String getBGSendingTIme() {
        return sharedPrefs.getString("bg_sending_time", null);
    }

    public void setBGSendingTIme(String sendingTime) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("bg_sending_time", sendingTime);
        editor.apply();
    }

    public float getTotalDistanceCar() {
        return sharedPrefs.getFloat("total_distance_car", 0);
    }

    public void setTotalDistanceCar(float distance) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putFloat("total_distance_car", distance);
        editor.apply();
    }

    public float getTotalDistanceBike() {
        return sharedPrefs.getFloat("total_distance_bike", 0);
    }

    public void setTotalDistanceBike(float distance) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putFloat("total_distance_bike", distance);
        editor.apply();
    }

    public void setshowhideWaybill(int showhidewaybill) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("showhidewaybill", showhidewaybill);
        editor.apply();
    }

    public int getshowhidewaybill() {
        return sharedPrefs.getInt("showhidewaybill", 0);
    }

    public String getCustomerCareNumber() {
        return sharedPrefs.getString("customer_care", "+8809604700700");
    }

    public void setCustomerCareNumber(String customerCare) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("customer_care", customerCare);
        editor.apply();
    }

    public String getSelectedLanguage() {
        return sharedPrefs.getString("Locale.Helper.Selected.Language", "en");
    }

    public void setSelectedLanguage(String languageCode) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("Locale.Helper.Selected.Language", languageCode);
        editor.apply();
    }

    public boolean getLanguageSelectionStatus() {
        return sharedPrefs.getBoolean("language_selection_status", false);
    }

    public void setLanguageSelectionStatus(boolean status) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("language_selection_status", status);
        editor.apply();
    }

    public int getMerchantId() {
        return sharedPrefs.getInt("merchant_id", 0);
    }

    public void setMerchantId(int merchantId) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("merchant_id", merchantId);
        editor.apply();
    }

    public int getWeight() {
        return sharedPrefs.getInt("weight", 0);
    }

    public void setWeight(int weight) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("weight", weight);
        editor.apply();
    }

    public int getWidth() {
        return sharedPrefs.getInt("width", 0);
    }

    public void setWidth(int width) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("width", width);
        editor.apply();
    }

    public void setHeight(int height) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("height", height);
        editor.apply();
    }

    public int getheight() {
        return sharedPrefs.getInt("height", 0);
    }

    public int getDepth() {
        return sharedPrefs.getInt("depth", 0);
    }

    public void setDepth(int depth) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("depth", depth);
        editor.apply();
    }

    //userType ParcelBD
    public void userType(String userType) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("user_type", userType);
        editor.apply();
    }

    public String getUserType() {
        return sharedPrefs.getString("user_type", "");
    }


    public void setThankYouActivityReached(boolean thankyou) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("thank_you", thankyou);
        editor.apply();
    }

    public boolean isThankYouReached() {
        return sharedPrefs.getBoolean("thank_you", false);
    }

    public String getUserFirstName() {
        return sharedPrefs.getString("user_first_name", "");
    }

    public void setUserFirstName(String name) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("user_first_name", name);
        editor.apply();
    }

    public String getUserLastName() {
        return sharedPrefs.getString("user_last_name", "");
    }

    public void setUserLastName(String name) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("user_last_name", name);
        editor.apply();
    }

    public Integer getUserZoneId() {
        return sharedPrefs.getInt("zone_id", 0);
    }

    public void setUserZoneId(Integer zoneId) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("zone_id", zoneId);
        editor.apply();
    }

    public String getDriverAppTripCancelText() {
        return sharedPrefs.getString("driver_app_trip_cancel_text", "");
    }

    public void setDriverAppTripCancelText(String driverAppTripCancelText) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("driver_app_trip_cancel_text", driverAppTripCancelText);
        editor.apply();
    }

    public String getLastTripEstimatedFare() {
        return sharedPrefs.getString("last_trip_estimated_fare", "");
    }

    public void setLastTripEstimatedFare(String lastTripEstimatedFare) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("last_trip_estimated_fare", lastTripEstimatedFare);
        editor.apply();
    }

    public String getLastTripCheckoutRequest() {
        return sharedPrefs.getString("last_trip_checkout_request", "");
    }

    public void setLastTripCheckoutRequest(String strLastTripCheckoutRequest) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("last_trip_checkout_request", strLastTripCheckoutRequest);
        editor.apply();
    }

    public int getLastTripCheckoutStatus() {
        return sharedPrefs.getInt("last_trip_checkout_status", 0);
    }

    public void setLastTripCheckoutStatus(int lastTripCheckoutStatus) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("last_trip_checkout_status", lastTripCheckoutStatus);
        editor.apply();
    }

    public void setSignUpVehicleTypes(String signUpVehicleTypes) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("signup_vehicle_types", signUpVehicleTypes);
        editor.apply();
    }

    public String getSignupVehicleTypes() {
        return sharedPrefs.getString("signup_vehicle_types", "");
    }

    public String getLastTripTotalMileage() {
        return sharedPrefs.getString("last_trip_total_mileage", "0");
    }

    public void setLastTripTotalMileage(String totalMileage) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("last_trip_total_mileage", totalMileage);
        editor.apply();
    }

    public String getLastTripTotalDuration() {
        return sharedPrefs.getString("last_trip_total_duration", "0");
    }

    public void setLastTripTotalDuration(String duration) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("last_trip_total_duration", duration);
        editor.apply();
    }

    public int getCategoryId() {
        return sharedPrefs.getInt("category_id", 0);
    }

    public void setCategoryId(int categoryId) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("category_id", categoryId);
        editor.apply();
    }

    public int getStoreId() {
        return sharedPrefs.getInt("store_id", 0);
    }

    public void setStoreId(int storeId) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("store_id", storeId);
        editor.apply();
    }

    //collected amount
    public void setcollectedAmout(int collected_amount) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("collected_amount", collected_amount);
        editor.apply();
    }


    public void setEvernoteJobId(int jobId) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("evernote_jobid", jobId);
        editor.apply();
    }

    public int getEvernotejobId() {
        return sharedPrefs.getInt("evernote_jobid", 1);
    }

    public String getUserZone() {
        return sharedPrefs.getString("user_zone", "");
    }

    public void setUserZone(String zone) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("user_zone", zone);
        editor.apply();
    }




   /* public void setCurrentTripStatus(CurrentTripStatus currentTripStatus){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("request_id",currentTripStatus.getRequestId());
        editor.putInt("trip_stage",currentTripStatus.getTripStage());
        editor.putInt("last_trip_id",currentTripStatus.getTripID());
        editor.apply();
    }

    public CurrentTripStatus getCurrentTripStatus(){
        CurrentTripStatus currentTripStatus = new CurrentTripStatus();
        currentTripStatus.setRequestId(sharedPrefs.getInt("request_id",0));
        currentTripStatus.setTripStage(sharedPrefs.getInt("trip_stage",0));
        currentTripStatus.setTripID(sharedPrefs.getInt("last_trip_id",0));
        return currentTripStatus;
    }

    public void setServiceData(ServiceData serviceData){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("ondemand",serviceData.getOndemand());
        editor.putInt("marketplace",serviceData.getMarketplace());
//        editor.putInt("marketplace",0);
        editor.putInt("emergency",serviceData.getEmergency());
        editor.putInt("quest",serviceData.getQuest());
        editor.apply();
    }

    public ServiceData getServiceData(){
        ServiceData serviceData = new ServiceData();
        serviceData.setOndemand(sharedPrefs.getInt("ondemand",1));
        serviceData.setMarketplace(sharedPrefs.getInt("marketplace",1));
        serviceData.setEmergency(sharedPrefs.getInt("emergency",1));
        serviceData.setQuest(sharedPrefs.getInt("quest",0));
        return serviceData;
    }

    public void setZoneData(ZoneData zoneData){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        if(zoneData.getZoneId()!=null){
            editor.putString("zone_id",zoneData.getZoneId());
        }
        if(zoneData.getCountryId()!=null){

            editor.putString("country_id",zoneData.getCountryId());
        }
        editor.putString("currency",zoneData.getCurrency());
        if (zoneData.getCurrency().equals("BDT")){
            editor.putString("currency_sign","৳");
        }else if (zoneData.getCurrency().equals("MMK")){
            editor.putString("currency_sign","Ks");
        }else if (zoneData.getCurrency().equals("USD")){
            editor.putString("currency_sign","$");
        }
        editor.putString("time_zone",zoneData.getTimeZone());
        editor.apply();
    }

    public ZoneData getZoneData(){
        ZoneData zoneData = new ZoneData();
        zoneData.setZoneId(sharedPrefs.getString("zone_id",""));
        zoneData.setCountryId(sharedPrefs.getString("country_id",""));
        zoneData.setCurrency(sharedPrefs.getString("currency",""));
        zoneData.setTimeZone(sharedPrefs.getString("time_zone",""));
        return zoneData;
    }

    public String getCurrencySign(){
        return sharedPrefs.getString("currency_sign","");
    }

    public void setLastTripRequestData(String lastTripRequestData){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("last_trip_request_data",lastTripRequestData);
        editor.apply();
    }

    public String getTripRequestData(){
        return sharedPrefs.getString("last_trip_request_data","");
    }

    public void setCurrentTripWayBill(String lastTripWaybill){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("last_trip_waybill",lastTripWaybill);
        editor.apply();
    }

    public String getCurrentTripWaybill(){
        return sharedPrefs.getString("last_trip_waybill","");
    }

    public void setRegistrationCountryId(int countryId){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("registration_country_id",countryId);
        editor.apply();
    }

    public int getRegistrationCountryId(){
        return sharedPrefs.getInt("registratoin_country_id",0);
    }

    public void setArriveTimeRoundTrip(String arriveTime){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("arrive_time",arriveTime);
        editor.apply();
    }

    public String getArriveTimeRoundTrip(){
        return sharedPrefs.getString("arrive_time",null);
    }

    public void setStartTimeRoundTrip(String startTime){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("start_time",startTime);
        editor.apply();
    }

    public String getStartTimeRoundTrip(){
        return sharedPrefs.getString("start_time",null);
    }

    public void setDestinationTimeRoundTrip(String destinationTime){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("destination_time",destinationTime);
        editor.apply();
    }

    public String getDestinationTimeRoundTrip(){
        return sharedPrefs.getString("destination_time",null);
    }

    public void setReturnStartTimeRoundTrip(String ReturnstartTime){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("Returnstart_time",ReturnstartTime);
        editor.apply();
    }

    public String getReturnStartTimeRoundTrip(){
        return sharedPrefs.getString("Returnstart_time",null);
    }

    public void setEzzyrAdminMessageCount(int count){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("ezzyr_admin_messages_count",count);
        editor.apply();
    }

    public int getEzzyrAdminMessageCount(){
        return sharedPrefs.getInt("ezzyr_admin_messages_count",0);
    }*/
}

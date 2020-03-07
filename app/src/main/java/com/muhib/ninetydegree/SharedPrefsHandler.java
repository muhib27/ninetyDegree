package com.muhib.ninetydegree;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPrefsHandler {
    private SharedPreferences sharedPrefs;

    private static final String userInOutStataus = "in_out_status";
    private static final String userBranchId = "branch_id";
    public static final String userGymId = "gym_id";
    private static final String keyusertype = "usertype";
    public static final String keyModelTestPrefs = "modelTestPrefs";
    public static final String keyusername = "username";
    public static final String keyuseremail = "email";
    public static final String keyusermobileno = "mobile";
    public static final String keyuserauthid = "authid";
    public static final String keyuserfirstname = "firstname";
    public static final String keyusermiddlename = "middlename";
    public static final String keyuserlastname = "lastname";
    public static final String keyuserdesignation = "designation";
    public static final String keyusergender = "gender";
    public static final String keyuserphoto = "photo";
    public static final String keyuserphotourl = "photoUrl";
    public static final String keyuseruserid = "userid";
    public static final String keyusertoken = "token";
    public static final String keyusermembercod = "membercode";
    public static final String keyuseraddress = "address";
    public static final String keyuserstatus = "status";
    public static final String keyuserproofname = "proofname";
    public static final String keyuseremergencycontact = "emergencycontact";
    public static final String keyuserhealthissues = "healthissues";
    public static final String keyuserpincode = "pincode";
    public static final String keyuseroccupation = "occupation";
    public static final String keyuseraim = "aim";
    public static final String keyusergymid = "gymid";
    public static final String keyuserheight = "height";
    public static final String keyuserweight = "weight";
    public static final String keyuserDOB = "DOB";
    private static final String keyIsFirstTime = "isFirstTime";
    private static final String keyuserTargetWeight = "targetweight";
    private static final String keyuserTargetPeriod = "targetperiod";

    private static final String keyFCMId = "fcm_id";

    private static SharedPreferences getSharedPreferences() {
        return AppApplication.getInstance().getSharedPreferences(keyModelTestPrefs, 0);
    }

    public SharedPrefsHandler(Context context) {
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void clear() {
      //  SharedPreferences.Editor editor = sharedPrefs.edit();
        final SharedPreferences pref = getSharedPreferences();
        final SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }


    public static void setFcm(String fcm_id) {
        final SharedPreferences pref = getSharedPreferences();
        final SharedPreferences.Editor editor = pref.edit();

        editor.putString(keyFCMId, fcm_id);
        editor.apply();
    }

    public static String getFcm() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyFCMId, "");
    }

    public static boolean getUsingFirstTime() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getBoolean(keyIsFirstTime, true);
    }

    public static void setUsingFirstTime(boolean isFirstTime) {
        final SharedPreferences pref = getSharedPreferences();
        final SharedPreferences.Editor editor = pref.edit();

        editor.putBoolean(keyIsFirstTime, isFirstTime);
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

    public String getOauthToken() {
        return sharedPrefs.getString("mobile_token", null);
    }

    public void setOauthToken(String mobileToken) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("mobile_token", mobileToken);
        editor.apply();
    }

    public String getAuthenticationCode() {
        return sharedPrefs.getString("authentication_code", null);
    }

    public void setAuthenticationCode(String mobileToken) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("authentication_code", mobileToken);
        editor.apply();
    }

    public static String getFCMRegistrationID() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString("fcm_registration_id", null);
    }

    public static void setFCMRegistrationID(String regID) {
        final SharedPreferences pref = getSharedPreferences();
        final SharedPreferences.Editor editor = pref.edit();
        editor.putString("fcm_registration_id", regID);
        editor.apply();
    }


    public static int getUserInfo() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getInt(keyusertype, 0);
    }

    public static void setUserInfo(int usertype,
                                   String usernamer,
                                   String email,
                                   String mobile,
                                   String firstname,
                                   String middlename,
                                   String lastname,
                                   String designation,
                                   String gender,
                                   String photoUrl,
                                    String token,
                                   String membercod,
                                   String address,
                                   String height,
                                   String weight,
                                   String DOB,
                                   int authid,
                                   int userid,
                                   int status,
                                   String targetweight,
                                   int targetperiod)
    {
        final SharedPreferences pref = getSharedPreferences();
        final SharedPreferences.Editor editor = pref.edit();

        editor.putInt(keyusertype, usertype);
        editor.putString(keyusername, usernamer);
        editor.putString(keyuseremail, email);
        editor.putString(keyusermobileno, mobile);
        editor.putString(keyuserfirstname, firstname);
        editor.putString(keyusermiddlename, middlename);
        editor.putString(keyuserlastname, lastname);
        editor.putString(keyuserdesignation, designation);
        editor.putString(keyusergender, gender);
        editor.putString(keyuserphotourl, photoUrl);
        editor.putString(keyusermembercod, membercod);
        editor.putString(keyuseraddress, address);
//        editor.putString(keyuserphoto, photo);
        editor.putString(keyuserheight, height);
        editor.putString(keyuserweight, weight);
        editor.putString(keyuserDOB, DOB);
        editor.putString(keyusertoken, token);
        editor.putString(keyuserTargetWeight, targetweight);
        editor.putInt(keyuserTargetPeriod, targetperiod);
        editor.putInt(keyuserauthid, authid);
        editor.putInt(keyuseruserid, userid);
        editor.putInt(keyuserstatus, status);
        editor.apply();
    }


    public static void setUserbranc(int branchId,
                                   int gymId
                                  )
    {
        final SharedPreferences pref = getSharedPreferences();
        final SharedPreferences.Editor editor = pref.edit();

        editor.putInt(userBranchId, branchId);
        editor.putInt(userGymId, gymId);

        editor.apply();
    }

    public static void setUserCheckInOut(int status)
    {
        final SharedPreferences pref = getSharedPreferences();
        final SharedPreferences.Editor editor = pref.edit();

        editor.putInt(userInOutStataus, status);

        editor.apply();
    }

    public static int getUserCheckInOut() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getInt(userInOutStataus, 0);
    }

    public static int getUserBranchId() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getInt(userBranchId, 0);
    }
    public static int getGymId() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getInt(userGymId, 0);
    }

    public static void setKeyuserphotourl(String photoUrl) {
        final SharedPreferences pref = getSharedPreferences();
        final SharedPreferences.Editor editor = pref.edit();
        editor.putString(keyuserphotourl, photoUrl);
        editor.apply();
    }



    public static String getUserInfoAnother() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuserproofname, "");
    }

    public static void setUserInfoAnother(String proofname, String emergencycontact, String healthissues, String pincode, String occupation, String aim, int gymid) {
        final SharedPreferences pref = getSharedPreferences();
        final SharedPreferences.Editor editor = pref.edit();
        editor.putString(keyuserproofname, proofname);
        editor.putString(keyuseremergencycontact, emergencycontact);
        editor.putString(keyuserhealthissues, healthissues);
        editor.putString(keyuserpincode, pincode);
        editor.putString(keyuseroccupation, occupation);
        editor.putString(keyuseraim, aim);
        editor.putString(keyuseraim, aim);
        editor.putInt(keyusergymid, gymid);

    }

    public static String getUserName() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyusername, "");
    }

    public static int getKeyusertype() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getInt(keyusertype, 0);
    }

    public static String getKeyuserTargetWeight() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuserTargetWeight, "");
    }

    public static int getKeyuserTargetPeriod() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getInt(keyuserTargetPeriod, 0);
    }
    public static String getKeyuserDOB() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuserDOB, "");
    }

    public static String getEmail() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuseremail, "");
    }

    public static String getKeyusermobileno() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyusermobileno, "");
    }

    public static String getKeyuserauthid() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuserauthid, "");
    }

    public static String getKeyuserweight() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuserweight, "");
    }

    public static String getKeyuserheight() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuserheight, "");
    }

    public static String getKeyuserfirstname() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuserfirstname, "");
    }

    public static String getKeyusermiddlename() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyusermiddlename, "");
    }

    public static String getKeyuserlastname() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuserlastname, "");
    }

    public static String getKeyuserdesignation() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuserdesignation, "");
    }

    public static String getKeyusergender() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyusergender, "");
    }

    public static String getKeyuserphotourl() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuserphotourl, "");
    }

    public static int getKeyuseruserid() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getInt(keyuseruserid, 0);
    }

    public static String getKeyuserphoto() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuserphoto, "");
    }

    public static String getKeyusertoken() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyusertoken, "");
    }

    public static String getKeyusermembercod() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyusermembercod, "");
    }

    public static String getKeyuseraddress() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuseraddress, "");
    }

    public static int getKeyuserstatus() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getInt(keyuserstatus, 0);
    }

    public static String getKeyuserproofname() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuserproofname, "");
    }

    public static String getKeyuseremergencycontact() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuseremergencycontact, "");
    }

    public static String getKeyuserhealthissues() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuserhealthissues, "");
    }

    public static String getKeyuserpincode() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuserpincode, "");
    }

    public static String getKeyuseroccupation() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuseroccupation, "");
    }

    public static String getKeyuseraim() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getString(keyuseraim, "");
    }

    public static int getKeyusergymid() {
        final SharedPreferences pref = getSharedPreferences();
        return pref.getInt(keyusergymid, 0);
    }


}

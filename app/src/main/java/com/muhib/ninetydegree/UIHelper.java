package com.muhib.ninetydegree;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;


public class UIHelper {

    ProgressDialog loadingDialog;
    Activity activity;
    UIHelper uiHelper;


    public UIHelper(Activity activity) {
        this.activity = activity;
        prettyDialog = new PrettyDialog(activity);
    }


    public void showMessage(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    public void showLoadingDialog(final String message) {

        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        loadingDialog = ProgressDialog.show(activity, "", message, true, false);
                        // MyProgressDialog.show(activity, "", message);
                    } catch (Exception e) {

                    }
                }
            });
        }
    }

//    public void loadGif(boolean enable){
//        RelativeLayout imageLayout = new RelativeLayout(activity);
//        GifImageView gifImageView = new GifImageView(activity);
//        gifImageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.edoozz_loader));
//        if(enable)
//            gifImageView.setVisibility(View.VISIBLE);
//        else
//            gifImageView.setVisibility(View.INVISIBLE);
//        gifImageView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
//        imageLayout.addView(gifImageView);
//    }

//    public void updateLoadingDialog(final String message) {
//        if (activity != null) {
//            activity.runOnUiThread(new Runnable() {
//                public void run() {
//                    loadingDialog.setMessage(message);
//                }
//            });
//        }
//    }
//
//    public boolean isDialogActive() {
//        if (loadingDialog != null) {
//            return loadingDialog.isShowing();
//        } else {
//            return false;
//        }
//    }
//
//    public void dismissLoadingDialog() {
//        if (activity != null && loadingDialog != null) {
//            loadingDialog.dismiss();
//            // MyProgressDialog.dismis(activity);
//
//        }
//    }
//
//    public void showErrorDialog(String errorMessage) {
//        new AlertDialog.Builder(activity).setMessage(errorMessage).setTitle(R.string.java_uihelper_error).setPositiveButton(R.string.java_uihelper_ok, new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                dialog.dismiss();
//            }
//        }).create().show();
//    }
//
//    public void showSuccessDialog(String errorMessage, String title) {
//        new AlertDialog.Builder(activity).setMessage(errorMessage).setTitle(title).setPositiveButton(R.string.java_uihelper_ok, new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                dialog.dismiss();
//            }
//        }).create().show();
//    }
//
//    public void showErrorDialogOnGuiThread(final String errorMessage) {
//        if (activity != null) {
//            activity.runOnUiThread(new Runnable() {
//                public void run() {
//                    new AlertDialog.Builder(activity).setMessage(errorMessage).setTitle(R.string.java_uihelper_error).setPositiveButton(R.string.java_uihelper_ok, new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            dialog.dismiss();
//                            dismissLoadingDialog();
//                        }
//                    }).create().show();
//                }
//            });
//        }
//    }

//    public void showInternetConnectivityDialog(String conenctionMessage, String title) {
//
//        final AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
//        dialog.setMessage(conenctionMessage);
//        dialog.setTitle(title);
//        dialog.setPositiveButton(R.string.java_uihelper_settings, new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // TODO Auto-generated method stub
//                activity.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
//                dialog.dismiss();
//            }
//        });
//
//        dialog.setNegativeButton(R.string.java_uihelper_ok, new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // TODO Auto-generated method stub
//                dialog.dismiss();
//            }
//        });
//
//        dialog.create();
//        dialog.show();
//
//
//    }


    String date = "";
    String time = "";
    int mYear;
    int mMonth;
    int mDay;

    int mHour;
    int mMinute;

    public String eventDateDialog() {
        // Get Current Date

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        final DatePickerDialog datePickerDialog = new DatePickerDialog(activity,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        date = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        //*************Call Time Picker Here ********************
                        //tiemPicker();

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

        datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                datePickerDialog.dismiss();
                return;
            }
        });
        return date;
    }

    public String tiemPicker() {
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(activity,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        mHour = hourOfDay;
                        mMinute = minute;

//                        et_show_date_time.setText(date_time+" "+hourOfDay + ":" + minute);
//                        eventTime.setText(hourOfDay + ":" + minute);
                        time = hourOfDay + ":" + minute;
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
        return time;
    }


    public static String dateTimeParse(String dateTime) {
//        String[] timeToAddParts = timeToAdd.split(" ");
        String parsedString = "";
        if (dateTime.contains(" ")) {
            String[] parts = dateTime.split(" ");
            if (!parts[0].isEmpty() && parts[0] != null)
                parsedString = parsedString + dateReverse(parts[0]);
//            if(!parts[1].isEmpty() && parts[1]!=null)
//                parsedString = parsedString + "  "+ parts[1].substring(0, parts[1].lastIndexOf(":"));
        } else if (!dateTime.isEmpty() && dateTime != null)
            parsedString = dateReverse(dateTime);


        return parsedString;
    }

    public static String TimeParse(String dateTime) {
        Date dt = null;
        String parsedString = "";
        if (dateTime.contains(" ")) {
            try {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dt = sdf.parse(dateTime);

                SimpleDateFormat sdfs = new SimpleDateFormat("hh:mm a");
                parsedString = sdfs.format(dt);

                Log.v("parseTime", parsedString);

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        return parsedString;
    }

    public static String dateReverse(String duedate, String times) {

        SimpleDateFormat format1 = new SimpleDateFormat("dd MMM, yyyy-HH:mm");
        //SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
//        format1.setTimeZone(TimeZone.getTimeZone("GMT"));
        String result = "";
        String returnResult = "";
        String dateText = duedate;
        String[] timeparts = times.split(":");

        if (dateText != null && dateText.contains("-")) {
            String[] parts = dateText.split("-");
            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, Integer.parseInt(parts[0]));
            c.set(Calendar.MONTH, Integer.parseInt(parts[1]) - 1);
            c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parts[2]));
            c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeparts[0]));
            c.set(Calendar.MINUTE, Integer.parseInt(timeparts[1]));
//            c.add(Calendar.MINUTE, timeToAdd);
            String tt = c.getTime().toString();


            // result = ( new SimpleDateFormat( "dd-MM-yyyy' 'HH:mm" ) ).format( c.getTime()).toString();;
            result = format1.format(c.getTime());
            String[] lastParse;
            if (result.contains("-")) {
                try {
                    lastParse = result.split("-");
                    returnResult = lastParse[0] + " at " + lastParse[1];
                } catch (Exception e) {

                }
            }

        }
        return returnResult;
    }

    public static String dateReverse(String duedate) {

        SimpleDateFormat format1 = new SimpleDateFormat("dd MMM, yyyy");
        //SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
//        format1.setTimeZone(TimeZone.getTimeZone("GMT"));
        String result = "";
        String returnResult = "";
        String dateText = duedate;


        if (dateText != null && dateText.contains("-")) {
            String[] parts = dateText.split("-");
            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, Integer.parseInt(parts[0]));
            c.set(Calendar.MONTH, Integer.parseInt(parts[1]) - 1);
            c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parts[2]));

//            c.add(Calendar.MINUTE, timeToAdd);
            String tt = c.getTime().toString();


            // result = ( new SimpleDateFormat( "dd-MM-yyyy' 'HH:mm" ) ).format( c.getTime()).toString();;
            result = format1.format(c.getTime());
            String[] lastParse;
//            if (result.contains("-")) {
//                try {
//                    lastParse = result.split("-");
//                    returnResult = lastParse[0] + " at " + lastParse[1];
//                } catch (Exception e) {
//
//                }
//            }

        }
        return result;
    }


//
//    @TargetApi(19)
//    @SuppressLint("NewApi")
//    public static String getPath(final Activity context, final Uri uri) {
//
//        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
//
//        // DocumentProvider
//        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
//            // ExternalStorageProvider
//            if (isExternalStorageDocument(uri)) {
//                final String docId = DocumentsContract.getDocumentId(uri);
//                final String[] split = docId.split(":");
//                final String type = split[0];
//
//                if ("primary".equalsIgnoreCase(type)) {
//                    return Environment.getExternalStorageDirectory() + "/"
//                            + split[1];
//                }
//
//                // TODO handle non-primary volumes
//            } else if (isDownloadsDocument(uri)) {
//
//                final String id = DocumentsContract.getDocumentId(uri);
//                final Uri contentUri = ContentUris.withAppendedId(
//                        Uri.parse("content://downloads/public_downloads"),
//                        Long.valueOf(id));
//
//                return getDataColumn(context, contentUri, null, null);
//            }
//
//            // MediaProvider
//            else if (isMediaDocument(uri)) {
//                final String docId = DocumentsContract.getDocumentId(uri);
//                final String[] split = docId.split(":");
//                final String type = split[0];
//
//                Uri contentUri = null;
//                if ("image".equals(type)) {
//                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
//                } else if ("video".equals(type)) {
//                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
//                } else if ("audio".equals(type)) {
//                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
//                }
//
//                final String selection = "_id=?";
//                final String[] selectionArgs = new String[]{split[1]};
//
//                return getDataColumn(context, contentUri, selection,
//                        selectionArgs);
//            } else if ("content".equalsIgnoreCase(uri.getScheme())) {
//
//                // Return the remote address
//                if (isGooglePhotosUri(uri))
//                    return uri.getLastPathSegment();
//
//                return getDataColumn(context, uri, null, null);
//            }
//            // File
//            else if ("file".equalsIgnoreCase(uri.getScheme())) {
//                return uri.getPath();
//            }
//        }
//        if (uri == null) {
//            // TODO perform some logging or show user feedback
//            return null;
//        } else {
//            // try to retrieve the image from the media store first
//            // this will only work for images selected from gallery
//            String[] projection = {MediaStore.Images.Media.DATA};
//            Cursor cursor = context.managedQuery(uri, projection, null, null, null);
//            if (cursor != null) {
//                int column_index = cursor
//                        .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//                cursor.moveToFirst();
//                return cursor.getString(column_index);
//            }
//            // this is our fallback here
//            return uri.getPath();
//        }
//    }


    private PrettyDialog prettyDialog;
    public void noInternet(boolean b)
    {

            if (!prettyDialog.isShowing()) {
                prettyDialog = new PrettyDialog(activity);
                prettyDialog
                        .setTitle("Internet Connection")
                        .setMessage("Please connect your internet connection.")
                        .addButton(
                                "Ok",
                                R.color.black,
                                R.color.orange_clr,
                                new PrettyDialogCallback() {
                                    @Override
                                    public void onClick() {
                                        prettyDialog.dismiss();
                                    }
                                }
                        )
                        .setIcon(R.drawable.ic_info_error)
                        .show();
            }

    }

}

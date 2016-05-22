package mehganc.tacoma.uw.edu.webservicelab.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mehgan on 4/19/2016.
 */
public class Course implements Serializable {
    public static final String ID = "id", SHORT_DESC = "shortDesc"
            , LONG_DESC = "longDesc", PRE_REQS = "prereqs";
    //public  List<Course> courseList = new ArrayList<Course>();
    private String mCourseID;
    private String mShortDescription;
    private String mLongDescription;
    private String mPrereqs;

    public Course(String courseID, String shortDesc, String longDesc, String prereqs) {
        mCourseID = courseID;
        mShortDescription = shortDesc;
        mLongDescription = longDesc;
        mPrereqs = prereqs;
    }

    /**
     * Parses the json string, returns an error message if unsuccessful.
     * Returns course list if success.
     * @param courseJSON
     * @return reason or null if successful.
     */
    public static String parseCourseJSON(String courseJSON, List<Course> courseList) {
        String reason = null;
        if (courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Course course = new Course(obj.getString(Course.ID), obj.getString(Course.SHORT_DESC)
                            , obj.getString(Course.LONG_DESC), obj.getString(Course.PRE_REQS));
                    courseList.add(course);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data, Reason: " + e.getMessage();
            }

        }
        return reason;
    }


    public void setId(String theid) {
        mCourseID = theid;
    }

    public void setShortDescription(String shortDesc) {
        mShortDescription = shortDesc;
    }

    public void setLongDescription(String longDesc) {
        mLongDescription = longDesc;
    }
    public void setPrereqs(String prereqs) {
        mPrereqs = prereqs;
    }
    public void setCourseId(String courseID)  {
        if (courseID == null || courseID.length() < 5) {
            throw new IllegalArgumentException();
        }
        mCourseID = courseID;
    }

    public String getCourseId () {
        return mCourseID;
    }
    public String getShortDescription () {
        return mShortDescription;
    }
    public String getLongDescription () {
        return mLongDescription;
    }

    public String getPrereqs() {
        return mPrereqs;
    }
}

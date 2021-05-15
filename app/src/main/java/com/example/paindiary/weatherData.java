package com.example.paindiary;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {
    private String mTemperature, mcity, mpressure,mhumidity,mWeatherType;
    private int mCondition;

    public static weatherData fromJson(JSONObject jsonObject){
        try{
            weatherData weatherD = new weatherData();
            weatherD.mcity=jsonObject.getString("name");
            weatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");

            double tempResult =jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            weatherD.mWeatherType= Integer.toString(roundedValue);

            int presResult = jsonObject.getJSONObject("main").getInt("pressure");
            weatherD.mWeatherType=Integer.toString(presResult);

            int humiResult = jsonObject.getJSONObject("main").getInt("humidity");
            weatherD.mWeatherType=Integer.toString(humiResult);

            return weatherD;

        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getmTemperature() {
        return mTemperature+"°C";
    }

    public String getMcity() {
        return mcity;
    }

    public String getMpressure() {
        return mpressure;
    }

    public String getMhumidity() {
        return mhumidity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }
}

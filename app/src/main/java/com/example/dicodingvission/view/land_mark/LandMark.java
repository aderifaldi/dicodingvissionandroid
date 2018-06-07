package com.example.dicodingvission.view.land_mark;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LandMark {


    /**
     * result : {"landmarks":[{"name":"Space Needle","confidence":0.9998177886009216}]}
     * requestId : 2b21906b-8abe-4827-b1e5-85de03b3744e
     * metadata : {"height":4132,"width":2096,"format":"Jpeg"}
     */

    @SerializedName("result")
    private Result result;
    @SerializedName("requestId")
    private String requestId;
    @SerializedName("metadata")
    private Metadata metadata;

    public Result getResult() {
        return result;
    }

    public String getRequestId() {
        return requestId;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public static class Result {
        @SerializedName("landmarks")
        private List<Landmarks> landmarks;

        public List<Landmarks> getLandmarks() {
            return landmarks;
        }

        public static class Landmarks {
            /**
             * name : Space Needle
             * confidence : 0.9998177886009216
             */

            @SerializedName("name")
            private String name;
            @SerializedName("confidence")
            private double confidence;

            public String getName() {
                return name;
            }

            public double getConfidence() {
                return confidence;
            }
        }
    }

    public static class Metadata {
        /**
         * height : 4132
         * width : 2096
         * format : Jpeg
         */

        @SerializedName("height")
        private int height;
        @SerializedName("width")
        private int width;
        @SerializedName("format")
        private String format;

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public String getFormat() {
            return format;
        }

    }
}

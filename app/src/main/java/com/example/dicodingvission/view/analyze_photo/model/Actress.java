package com.example.dicodingvission.view.analyze_photo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Actress {


    /**
     * result : {"celebrities":[{"faceRectangle":{"top":49,"left":43,"width":89,"height":89},"name":"Taylor Swift","confidence":0.999275267124176}]}
     * requestId : 3c471556-5989-4c1f-b62a-28f9dca3ef0c
     * metadata : {"height":261,"width":220,"format":"Jpeg"}
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

    public void setResult(Result result) {
        this.result = result;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public static class Result {
        @SerializedName("celebrities")
        private List<Celebrities> celebrities;

        public List<Celebrities> getCelebrities() {
            return celebrities;
        }

        public void setCelebrities(List<Celebrities> celebrities) {
            this.celebrities = celebrities;
        }

        public static class Celebrities {
            /**
             * faceRectangle : {"top":49,"left":43,"width":89,"height":89}
             * name : Taylor Swift
             * confidence : 0.999275267124176
             */

            @SerializedName("faceRectangle")
            private FaceRectangle faceRectangle;
            @SerializedName("name")
            private String name;
            @SerializedName("confidence")
            private double confidence;

            public FaceRectangle getFaceRectangle() {
                return faceRectangle;
            }

            public void setFaceRectangle(FaceRectangle faceRectangle) {
                this.faceRectangle = faceRectangle;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getConfidence() {
                return confidence;
            }

            public void setConfidence(double confidence) {
                this.confidence = confidence;
            }

            public static class FaceRectangle {
                /**
                 * top : 49
                 * left : 43
                 * width : 89
                 * height : 89
                 */

                @SerializedName("top")
                private int top;
                @SerializedName("left")
                private int left;
                @SerializedName("width")
                private int width;
                @SerializedName("height")
                private int height;

                public int getTop() {
                    return top;
                }

                public void setTop(int top) {
                    this.top = top;
                }

                public int getLeft() {
                    return left;
                }

                public void setLeft(int left) {
                    this.left = left;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }
            }
        }
    }

    public static class Metadata {
        /**
         * height : 261
         * width : 220
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

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }
    }
}

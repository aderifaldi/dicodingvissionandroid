package com.example.dicodingvission.view.analyze_photo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AutoCaption {


    /**
     * description : {"tags":["outdoor","person","clothing","beach","water","woman","surfing","carrying","standing","young","white","wearing","sand","board","walking","holding","suit","black","girl","man","ocean"],"captions":[{"text":"a woman standing on a beach","confidence":0.9636017395601711}]}
     * requestId : 89704f14-8a57-4a6e-9e3d-5e4c71424d22
     * metadata : {"height":723,"width":600,"format":"Jpeg"}
     */

    @SerializedName("description")
    private Description description;
    @SerializedName("requestId")
    private String requestId;
    @SerializedName("metadata")
    private Metadata metadata;

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
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

    public static class Description {
        @SerializedName("tags")
        private List<String> tags;
        @SerializedName("captions")
        private List<Captions> captions;

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public List<Captions> getCaptions() {
            return captions;
        }

        public void setCaptions(List<Captions> captions) {
            this.captions = captions;
        }

        public static class Captions {
            /**
             * text : a woman standing on a beach
             * confidence : 0.9636017395601711
             */

            @SerializedName("text")
            private String text;
            @SerializedName("confidence")
            private double confidence;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public double getConfidence() {
                return confidence;
            }

            public void setConfidence(double confidence) {
                this.confidence = confidence;
            }
        }
    }

    public static class Metadata {
        /**
         * height : 723
         * width : 600
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

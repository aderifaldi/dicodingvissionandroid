package com.example.dicodingvission.view.analize;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AnalizePhoto {

    /**
     * categories : [{"name":"outdoor_street","score":0.625,"detail":{"landmarks":[]}}]
     * description : {"tags":["outdoor","building","street","city","busy","traffic","filled","people","car","walking","many","crowded","bunch","group","night","large","table","light","man","standing","umbrella","riding","tall","sign","rain","road"],"captions":[{"text":"a crowded city street filled with traffic at night","confidence":0.951690173902612}]}
     * color : {"dominantColorForeground":"Brown","dominantColorBackground":"Brown","dominantColors":["Brown"],"accentColor":"B74314","isBwImg":false}
     * requestId : dbec6fae-a5c0-4bd0-9d33-c5b3cb0ae451
     * metadata : {"height":2436,"width":1826,"format":"Jpeg"}
     */

    @SerializedName("description")
    private Description description;
    @SerializedName("color")
    private Color color;
    @SerializedName("requestId")
    private String requestId;
    @SerializedName("metadata")
    private Metadata metadata;
    @SerializedName("categories")
    private List<Categories> categories;

    public Description getDescription() {
        return description;
    }

    public Color getColor() {
        return color;
    }

    public String getRequestId() {
        return requestId;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public static class Description {
        @SerializedName("tags")
        private List<String> tags;
        @SerializedName("captions")
        private List<Captions> captions;

        public List<String> getTags() {
            return tags;
        }

        public List<Captions> getCaptions() {
            return captions;
        }

        public static class Captions {
            /**
             * text : a crowded city street filled with traffic at night
             * confidence : 0.951690173902612
             */

            @SerializedName("text")
            private String text;
            @SerializedName("confidence")
            private double confidence;

            public String getText() {
                return text;
            }

            public double getConfidence() {
                return confidence;
            }
        }
    }

    public static class Color {
        /**
         * dominantColorForeground : Brown
         * dominantColorBackground : Brown
         * dominantColors : ["Brown"]
         * accentColor : B74314
         * isBwImg : false
         */

        @SerializedName("dominantColorForeground")
        private String dominantColorForeground;
        @SerializedName("dominantColorBackground")
        private String dominantColorBackground;
        @SerializedName("accentColor")
        private String accentColor;
        @SerializedName("isBwImg")
        private boolean isBwImg;
        @SerializedName("dominantColors")
        private List<String> dominantColors;

        public String getDominantColorForeground() {
            return dominantColorForeground;
        }

        public String getDominantColorBackground() {
            return dominantColorBackground;
        }

        public String getAccentColor() {
            return accentColor;
        }

        public boolean isIsBwImg() {
            return isBwImg;
        }

        public List<String> getDominantColors() {
            return dominantColors;
        }

    }

    public static class Metadata {
        /**
         * height : 2436
         * width : 1826
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

    public static class Categories {
        /**
         * name : outdoor_street
         * score : 0.625
         * detail : {"landmarks":[]}
         */

        @SerializedName("name")
        private String name;
        @SerializedName("score")
        private double score;

        public String getName() {
            return name;
        }

        public double getScore() {
            return score;
        }

    }
}

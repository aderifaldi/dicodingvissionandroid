package com.example.dicodingvission.view.analyze_photo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Analyze {

    /**
     * categories : [{"name":"people_","score":0.98828125}]
     * faces : [{"age":29,"gender":"Female","faceRectangle":{"top":84,"left":257,"width":85,"height":85}}]
     * adult : {"isAdultContent":false,"adultScore":0.036051180213689804,"isRacyContent":true,"racyScore":0.9632097482681274}
     * color : {"dominantColorForeground":"Brown","dominantColorBackground":"Grey","dominantColors":["Grey"],"accentColor":"4E587D","isBwImg":false}
     * imageType : {"clipArtType":0,"lineDrawingType":0}
     * requestId : 0760c1e6-9a9f-4d69-88d6-29f6602e7092
     * metadata : {"height":723,"width":600,"format":"Jpeg"}
     */

    @SerializedName("adult")
    private Adult adult;
    @SerializedName("color")
    private Color color;
    @SerializedName("imageType")
    private ImageType imageType;
    @SerializedName("requestId")
    private String requestId;
    @SerializedName("metadata")
    private Metadata metadata;
    @SerializedName("categories")
    private List<Categories> categories;
    @SerializedName("faces")
    private List<Faces> faces;

    public Adult getAdult() {
        return adult;
    }

    public void setAdult(Adult adult) {
        this.adult = adult;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
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

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public List<Faces> getFaces() {
        return faces;
    }

    public void setFaces(List<Faces> faces) {
        this.faces = faces;
    }

    public static class Adult {
        /**
         * isAdultContent : false
         * adultScore : 0.036051180213689804
         * isRacyContent : true
         * racyScore : 0.9632097482681274
         */

        @SerializedName("isAdultContent")
        private boolean isAdultContent;
        @SerializedName("adultScore")
        private double adultScore;
        @SerializedName("isRacyContent")
        private boolean isRacyContent;
        @SerializedName("racyScore")
        private double racyScore;

        public boolean isIsAdultContent() {
            return isAdultContent;
        }

        public void setIsAdultContent(boolean isAdultContent) {
            this.isAdultContent = isAdultContent;
        }

        public double getAdultScore() {
            return adultScore;
        }

        public void setAdultScore(double adultScore) {
            this.adultScore = adultScore;
        }

        public boolean isIsRacyContent() {
            return isRacyContent;
        }

        public void setIsRacyContent(boolean isRacyContent) {
            this.isRacyContent = isRacyContent;
        }

        public double getRacyScore() {
            return racyScore;
        }

        public void setRacyScore(double racyScore) {
            this.racyScore = racyScore;
        }
    }

    public static class Color {
        /**
         * dominantColorForeground : Brown
         * dominantColorBackground : Grey
         * dominantColors : ["Grey"]
         * accentColor : 4E587D
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

        public void setDominantColorForeground(String dominantColorForeground) {
            this.dominantColorForeground = dominantColorForeground;
        }

        public String getDominantColorBackground() {
            return dominantColorBackground;
        }

        public void setDominantColorBackground(String dominantColorBackground) {
            this.dominantColorBackground = dominantColorBackground;
        }

        public String getAccentColor() {
            return accentColor;
        }

        public void setAccentColor(String accentColor) {
            this.accentColor = accentColor;
        }

        public boolean isIsBwImg() {
            return isBwImg;
        }

        public void setIsBwImg(boolean isBwImg) {
            this.isBwImg = isBwImg;
        }

        public List<String> getDominantColors() {
            return dominantColors;
        }

        public void setDominantColors(List<String> dominantColors) {
            this.dominantColors = dominantColors;
        }
    }

    public static class ImageType {
        /**
         * clipArtType : 0
         * lineDrawingType : 0
         */

        @SerializedName("clipArtType")
        private int clipArtType;
        @SerializedName("lineDrawingType")
        private int lineDrawingType;

        public int getClipArtType() {
            return clipArtType;
        }

        public void setClipArtType(int clipArtType) {
            this.clipArtType = clipArtType;
        }

        public int getLineDrawingType() {
            return lineDrawingType;
        }

        public void setLineDrawingType(int lineDrawingType) {
            this.lineDrawingType = lineDrawingType;
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

    public static class Categories {
        /**
         * name : people_
         * score : 0.98828125
         */

        @SerializedName("name")
        private String name;
        @SerializedName("score")
        private double score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }

    public static class Faces {
        /**
         * age : 29
         * gender : Female
         * faceRectangle : {"top":84,"left":257,"width":85,"height":85}
         */

        @SerializedName("age")
        private int age;
        @SerializedName("gender")
        private String gender;
        @SerializedName("faceRectangle")
        private FaceRectangle faceRectangle;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public FaceRectangle getFaceRectangle() {
            return faceRectangle;
        }

        public void setFaceRectangle(FaceRectangle faceRectangle) {
            this.faceRectangle = faceRectangle;
        }

        public static class FaceRectangle {
            /**
             * top : 84
             * left : 257
             * width : 85
             * height : 85
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

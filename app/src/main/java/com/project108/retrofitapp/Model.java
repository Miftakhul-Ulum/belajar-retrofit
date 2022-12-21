package com.project108.retrofitapp;

import java.util.List;

import javax.xml.transform.Result;

public class Model {

    private List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public class Result{

        private String id;
        private String title;
        private String image;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title){
            this.title=title;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", image='" + image + '\'' +
                    '}';
        }
    }
}

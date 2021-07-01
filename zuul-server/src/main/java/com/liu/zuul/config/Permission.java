package com.liu.zuul.config;

public class Permission{
        private String method;
        private String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        @Override
        public String toString() {
            return "Permission{" +
                    "method='" + method + '\'' +
                    ", path='" + path + '\'' +
                    '}';
        }
    }
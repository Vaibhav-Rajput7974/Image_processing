package com.example.Image_processing_app.app1;

import com.example.Image_processing_app.app1.operation.Operation;

import java.util.HashMap;

public class ImageProcessing {
    private Operation operation;

    protected java.util.Map<String,Image> images = new HashMap<>();

    public ImageProcessing(Operation operation) {
        this.operation = operation;
    }

    public void push( Image image){
        images.put(image.getName(), image);
    }

    public Image pop(){
        Image  current = images.get(images.size()-1);
        images.remove(current);
        return current;
    }

    public void start(){
        Iterator iterator = createItorato();
        while (iterator.hasNext()){
            operation.process(iterator.next());
        }
    }

    public Iterator createItorato(){
        return new Map(this);
    }

    class Map implements Iterator{
        private ImageProcessing imageProcessing;
        java.util.Iterator<java.util.Map.Entry<String, Image>> current = images.entrySet().iterator();
        public Map(ImageProcessing imageProcessing) {
            this.imageProcessing = imageProcessing;
        }

        @Override
        public boolean hasNext() {
            return current.hasNext();
        }

        @Override
        public Image next() {
            return images.get(current.next().getKey());
        }
    }
}

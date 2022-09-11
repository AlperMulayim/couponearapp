package com.alper.couponear.referencesystem;

public  class ReferenceSystem {
    public Integer calculateReferencePoint(Integer numOfReference){
        Integer referencePoint = 0;

        if(numOfReference  > 10){
            referencePoint = 5;
        }
        if(numOfReference > 25){
            referencePoint = 10;
        }
        if(numOfReference > 100 ){
            referencePoint = 10;
        }
        return  referencePoint;
    }
}

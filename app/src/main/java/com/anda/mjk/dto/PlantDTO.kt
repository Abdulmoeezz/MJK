package com.anda.mjk.dto

data class PlantDTO(

    var id:Int =0,
    var genus:String,
    var species:String,
    var cultivar:String,
    var common:String
){

    override fun toString(): String {
        return "$genus  $species $cultivar $common $id"
    }


}
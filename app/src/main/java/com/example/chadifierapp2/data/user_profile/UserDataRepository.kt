package com.example.chadifierapp2.data.user_profile

public class UserDataRepository (
    val user_name: String
) {
//    this repository will handle the user profile data transactions, to affect and syncronize the data on the model
    private var userData: UserDataModel = UserDataModel(name= user_name)

    fun getUserName() : String {
        return userData.name
    }

    fun getChadPoints() : Int {
        return userData.numChadPoints
    }
    fun addChadPoints(numPoints: Int) {
        userData.numChadPoints += numPoints
    }

    fun reduceChadPoints(numPoints: Int) {
        userData.numChadPoints -= numPoints
    }

    fun fetchRemoteChadPoints() {

    }

    fun pullRemoteChadPoints() {

    }

    fun getChadLevel() : Int{
        return  userData.chadLevel
    }
    fun increaseChadLevel() {
        userData.chadLevel += 1
    }

    fun decreaseChadLevel() {
        userData.chadLevel -= 1
    }

    fun fetchRemoteChadLevel() {

    }

    fun pullRemoteChadLevel() {

    }


}
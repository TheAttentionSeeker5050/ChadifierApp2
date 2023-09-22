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

//        check the level
        checkUserLevel()
    }

    fun reduceChadPoints(numPoints: Int) {
        if (userData.numChadPoints - numPoints >= 0) {
            userData.numChadPoints -= numPoints

        } else {
            userData.numChadPoints = 0
        }

//        check the level
        checkUserLevel()
    }

//    change level setters
    fun levelUp() {
        userData.chadLevel += 1
    }

    fun levelDown() {
        if (userData.chadLevel - 1 >= 0) {
            userData.chadLevel -= 1

        } else {
            userData.chadLevel = 0
        }
    }



    fun checkUserLevel() {
//        find the level in the user data level list
        if (userData.chadLevel < 0) {
            return
        }

        if (userData.chadLevel > 49) {
            return
        }

        val nextChadLevelPoints = userDataLevelList[userData.chadLevel].minPoints

        if (userData.numChadPoints > nextChadLevelPoints) {
            levelUp()
        }

    }

    fun getUserLevel() : Int {
        return userData.chadLevel
    }

    fun fetchRemoteChadPoints() {

    }

    fun pullRemoteChadPoints() {

    }



}
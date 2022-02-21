package com.example.myapplication

class APIUtils {
    companion object {

        private val BASE_URL = "http://demo.equalinfotech.com/rehablab/api/care/"

        fun getServiceAPI(): APIConfiguration? {
            return APIClient.getApiClient(BASE_URL)!!.create(APIConfiguration::class.java)


        }
    }
}
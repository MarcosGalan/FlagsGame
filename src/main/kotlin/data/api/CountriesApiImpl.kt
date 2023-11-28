package data.api

import com.google.gson.Gson
import data.api.models.CountryCapital.CountryCapital
import data.api.models.CountryCodes.CountryCodes
import data.api.models.CountryFlag.CountryFlag
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

object CountriesApiImpl : CountriesApi {

    private const val url: String = "https://restcountries.com/v3.1"

    override fun getCountriesCodes(): List<String> {

        try {

            val connection = URL("$url/all?fields=cca3").openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val bufferedReader = BufferedReader(InputStreamReader(connection.inputStream))
                val response = bufferedReader.readText()

                return Gson().fromJson(response, CountryCodes::class.java).map { it.cca3 }
            } else {
                throw Exception("API call failed with code $responseCode")
            }
        } catch (e: Exception) {
            throw Exception("Connection Error: $e")
        }

    }

    override fun getCountryFlagsData(countryCode: String): CountryFlag {
        try {
            val connection =
                URL("$url/alpha/$countryCode?fields=name,flags").openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val bufferedReader = BufferedReader(InputStreamReader(connection.inputStream))
                val response = bufferedReader.readText()

                return Gson().fromJson(response, CountryFlag::class.java)
            } else {
                throw Exception("API call failed with code $responseCode")
            }
        } catch (e: Exception) {
            throw Exception("Connection Error: $e")
        }

    }

    override fun getCountryCapitalData(countryCode: String): CountryCapital {
        try {
            val connection =
                URL("$url/alpha/$countryCode?fields=name,capital").openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val bufferedReader = BufferedReader(InputStreamReader(connection.inputStream))
                val response = bufferedReader.readText()

                return Gson().fromJson(response, CountryCapital::class.java)
            } else {
                throw Exception("API call failed with code $responseCode")
            }
        } catch (e: Exception) {
            throw Exception("Connection Error: $e")
        }

    }

}
package data.api

import data.api.models.CountryCapital.CountryCapital
import data.api.models.CountryFlag.CountryFlag

interface CountriesApi {

    fun getCountriesCodes(): List<String>

    fun getCountryFlagsData(countryCode: String): CountryFlag

    fun getCountryCapitalData(countryCode: String): CountryCapital

}
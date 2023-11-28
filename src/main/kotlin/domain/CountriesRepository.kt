package domain

interface CountriesRepository {

    fun getCountriesCodes(): List<String>

    fun getCountryFlagsData(countryCode: String): Country

    fun getCountryCapitalData(countryCode: String): Country



}
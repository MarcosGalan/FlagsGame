package domain

import data.api.CountriesApiImpl
import data.repository.CountriesRepositoryImpl

class CountriesManager() {

    private var countryCodes: MutableList<String> = CountriesApiImpl.getCountriesCodes().toMutableList()


    fun getRandomCountryCode():String{
        if(countryCodes.isEmpty()){
            countryCodes = CountriesApiImpl.getCountriesCodes().toMutableList()
        }
        return countryCodes.let {
            val randomElement = it.random()
            countryCodes.remove(randomElement)
            randomElement
        }
    }

    fun getCountryFlagsData(countryCode: String): Country{
        return CountriesRepositoryImpl.getCountryFlagsData(countryCode)
    }

    fun getCountryCapitalData(countryCode: String): Country{
        return CountriesRepositoryImpl.getCountryCapitalData(countryCode)
    }



}
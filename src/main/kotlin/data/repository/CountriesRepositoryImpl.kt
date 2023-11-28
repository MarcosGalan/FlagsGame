package data.repository

import data.api.CountriesApiImpl
import domain.CountriesRepository
import domain.Country

object CountriesRepositoryImpl: CountriesRepository {
    override fun getCountriesCodes(): List<String> {
        return CountriesApiImpl.getCountriesCodes()
    }

    override fun getCountryFlagsData(countryCode: String): Country {
        return CountriesApiImpl.getCountryFlagsData(countryCode).let {
            Country(countryCode,it.name.common,"",it.flags.png)
        }
    }

    override fun getCountryCapitalData(countryCode: String): Country {
        return CountriesApiImpl.getCountryCapitalData(countryCode).let {
            Country(countryCode,it.name.common,it.capital[0],"")
        }
    }

}
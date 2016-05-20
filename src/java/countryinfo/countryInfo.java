/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countryinfo;


import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;


/**
 *
 * @author Tristan
 */
@WebService(serviceName = "countryInfo")
public class countryInfo {

    /**
     * This is a sample web service operation
     * @param pais
     * @return 
     */
    @WebMethod(operationName = "servicio")
    public String[] servicio(@WebParam(name = "pais") String pais) {
        GlobalWeather gw = new GlobalWeather();
        GlobalWeatherSoap gwSoap = gw.getGlobalWeatherSoap();
        
        Airport ap = new Airport();
        AirportSoap apSoap = ap.getAirportSoap();

        String[] result = {gwSoap.getCitiesByCountry(pais),apSoap.getAirportInformationByCountry(pais)};

        return result;
    }   
}

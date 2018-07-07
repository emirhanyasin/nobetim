/**
 * @author emirhan yasin cetin
 */
(function () {

    angular.module('nobetim').factory('HospitalService', HospitalService);

    HospitalService.$inject = ['$http', 'urlMapper'];

    function HospitalService($http, urlMapper) {
        return{

            getAllHospitals : function () {
                var httpPromise = $http.get(urlMapper.GET_ALL_HOSPITALS);
                return httpPromise;
            },

            getDepartments : function (hospitalName) {
                var data = {
                    hospitalName: hospitalName
                };

                var httpPromise = $http.get(urlMapper.GET_DEPARTMENTS, data);
                return httpPromise;
            }

        }
    }
}());

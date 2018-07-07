/**
 * @author emirhan yasin cetin
 */
(function () {

    angular.module('nobetim').factory('RegisterNewHospitalService', RegisterNewHospitalService);

    RegisterNewHospitalService.$inject = ['$http', 'urlMapper'];

    function RegisterNewHospitalService($http, urlMapper) {
        return{
            registerHospital: function (hospitalName, departmentName, password) {
                var data = {
                    hospitalName : hospitalName,
                    departmentName : departmentName,
                    password : password
                };

                var httpPromise = $http.post(urlMapper.NEW_HOSPITAL, data);
                return httpPromise;
            }

        }
    }
}());
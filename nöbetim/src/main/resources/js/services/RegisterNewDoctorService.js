/**
 * @author emirhan yasin cetin
 */
(function () {

    angular.module('nobetim').factory('RegisterNewDoctorService', RegisterNewDoctorService);

    RegisterNewDoctorService.$inject = ['$http', 'urlMapper'];

    function RegisterNewDoctorService($http, urlMapper) {
        return{
            registerDoctor: function (id, firstName, lastName, level, age, hospital, department, eMail, gsmnumber) {
                var data = {
                    id : id,
                    firstName : firstName,
                    lastName : lastName,
                    level : level,
                    age : age,
                    hospital : hospital,
                    department : department,
                    eMail : eMail,
                    gsmnumber : gsmnumber
                };

                var httpPromise = $http.post(urlMapper.NEW_DOCTOR, data);
                return httpPromise;
            }

        }
    }
}());

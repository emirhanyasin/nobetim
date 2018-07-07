/**
 * @author emirhan yasin cetin
 */
(function () {

    angular.module('nobetim').factory('DoctorsService', DoctorsService);

    DoctorsService.$inject = ['$http', 'urlMapper'];

    function DoctorsService($http, urlMapper) {
        return{

            getAllDoctors : function () {
                var httpPromise = $http.get(urlMapper.GET_ALL_DOCTORS);
                return httpPromise;
            },

            getAllDoctorNames : function () {
                var httpPromise = $http.get(urlMapper.GET_ALL_DOCTOR_NAMES);
                return httpPromise;
            },

            updateDoctor : function (id, firstName, lastName, level, age, hospital, department, eMail, gsmnumber) {
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

                var httpPromise = $http.post(urlMapper.UPDATE_DOCTOR, data);
                return httpPromise;
            },

            deleteDoctor : function (id) {
                var data = {
                    id : id
                };

                var httpPromise = $http.post(urlMapper.DELETE_DOCTOR, data);
                return httpPromise;
            }

        }
    }
}());
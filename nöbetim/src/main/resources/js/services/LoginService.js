/**
 * @author emirhan yasin cetin
 */
(function () {

    angular.module('nobetim').factory('LoginService', LoginService);

    LoginService.$inject = ['$http', 'urlMapper'];

    function LoginService($http, urlMapper) {
        return{

            isAuthenticate : function (hospitalName, departmentName, password) {
                var data = {
                    hospitalName : hospitalName,
                    departmentName : departmentName,
                    password : password
                };

                var httpPromise = $http.post(urlMapper.AUTHENTICATE, data);
                return httpPromise;
            }


        }
    }
}());
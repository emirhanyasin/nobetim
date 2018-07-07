/**
 * @author emirhan yasin cetin
 */
(function () {
    angular.module('nobetim', []).controller('LoginController', LoginController);

    LoginController.$inject = ['$scope', 'LoginService'];

    function LoginController($scope, LoginService) {

        $scope.login = {};

        $scope.isAuthenticate = function () {
            LoginService.isAuthenticate($scope.login.hospitalName, $scope.login.departmentName, $scope.login.password);

        };

        $scope.inputType = 'password';

        // Hide & show password function
        $scope.hideShowPassword = function(){
            if ($scope.inputType == 'password')
                $scope.inputType = 'text';
            else
                $scope.inputType = 'password';
        };

        $scope.hospitals = {};


    }

}());
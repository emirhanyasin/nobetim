/**
 * @author emirhan yasin cetin
 */
(function () {

    angular.module('nobetim', []).controller('RegisterNewHospitalController', RegisterNewHospitalController);

    RegisterNewHospitalController.$inject = ['$scope', 'RegisterNewHospitalService'];

    function RegisterNewHospitalController($scope, RegisterNewHospitalService) {

        $scope.newHospital = {};
        $scope.newHospital.inProgress = false;

        //register a new hospital
        $scope.registerHospital = function () {

            $scope.newHospital.inProgress = true;

            RegisterNewHospitalService.registerHospital($scope.newHospital.hospitalName, $scope.newHospital.departmentName, $scope.newHospital.password)
                .finally(function () {
                    $scope.newHospital.inProgress = false;
                    //$scope.reload();
                });
        };

        $scope.inputType = 'password';

        // Hide & show password function
        $scope.hideShowPassword = function(){
            if ($scope.inputType == 'password')
                $scope.inputType = 'text';
            else
                $scope.inputType = 'password';
        };

        $scope.reload = function () {
            window.location.reload();
        }

    }
}());

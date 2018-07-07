/**
 * @author emirhan yasin cetin
 */
(function () {
    angular.module('nobetim', []).controller('RegisterNewDoctorController', RegisterNewDoctorController);

    RegisterNewDoctorController.$inject = ['$scope', 'RegisterNewDoctorService'];

    function RegisterNewDoctorController($scope, RegisterNewDoctorService) {

        $scope.newDoctor = {};
        $scope.newDoctor.inProgress = false;

        //register a new hospital
        $scope.registerDoctor = function () {

            $scope.newDoctor.inProgress = true;

            RegisterNewDoctorService.registerDoctor($scope.newDoctor.doctorId, $scope.newDoctor.firstName, $scope.newDoctor.lastName, $scope.newDoctor.doctorLevel, $scope.newDoctor.doctorAge, $scope.newDoctor.doctorHospital, $scope.newDoctor.doctorDepartment, $scope.newDoctor.doctoreMail, $scope.newDoctor.doctorGSMNumber)
                .finally(function () {
                    $scope.newDoctor.inProgress = false;
                    $scope.reload();
                });
        };

        $scope.reload = function () {
            window.location.reload();
        }

    }

}());

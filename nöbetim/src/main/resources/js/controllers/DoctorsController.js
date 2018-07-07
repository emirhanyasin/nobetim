/**
 * @author emirhan yasin cetin
 */
(function () {
    angular.module('nobetim', []).controller('DoctorsController', DoctorsController);

    DoctorsController.$inject = ['$scope', 'DoctorsService'];

    function DoctorsController($scope, DoctorsService) {

        $scope.getAllDoctors = function () {
            DoctorsService.getAllDoctors().then(function (data) {
                $scope.doctors = data;
            }, function (err) {
                $scope.doctors = {error: err}
            });
        };

        $scope.getAllDoctorNames = function () {
            DoctorsService.getAllDoctorNames().then(function (data) {
                $scope.doctorNames = data;
            }, function (err) {
                $scope.doctors = {error: err}
            });
        };

        $scope.updateDoctor = function (id, firstName, lastName, level, age, hospital, department, eMail, GSMNumber) {
            DoctorsService.updateDoctor(id, firstName, lastName, level, age, hospital, department, eMail, GSMNumber);
            $scope.reload();
        };

        $scope.deleteDoctor = function (id) {
            DoctorsService.deleteDoctor(id);
        };

        $scope.reload = function () {
            window.location.reload();
        }

    }

}());
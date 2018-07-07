/**
 *  @author emirhan yasin cetin
 */
(function () {
    angular.module('nobetim').constant('urlMapper', (function () {

        var prefix = '/nobetim';

        var urls = {
            NEW_HOSPITAL: '/newHospital',
            NEW_DOCTOR: '/newDoctor',
            AUTHENTICATE : '/authenticate',
            GET_ALL_DOCTORS: '/allDoctors',
            GET_ALL_DOCTOR_NAMES: '/allDoctorNames',
            GET_DOCTOR_BY_ID: '/getDoctorById',
            DELETE_DOCTOR: '/deleteDoctor',
            UPDATE_DOCTOR: '/updateDoctor',
            GET_ALL_HOSPITALS: '/allHospitals',
            GET_DEPARTMENTS: '/departments'

        };

        angular.forEach(urls, function (definition, key) {
            urls[key] = definition;
        });

        return urls;
    }()));

}());
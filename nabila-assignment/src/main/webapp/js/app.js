angular.module("schoolResult.services", ["ngResource"]).
    factory('Result', function ($resource) {
        var Result = $resource('/school-result/api/v1/results/:subject', {subject: '@subject'});
        Result.prototype.isNew = function(){
            return (typeof(this.id) === 'undefined');
        }
        return Result;
    });

angular.module("schoolResult", ["schoolResult.services"]).
    config(function ($routeProvider) {
        $routeProvider
            .when('/results/:subject', {templateUrl: 'views/list.html', controller: ResultDetailController});
    });

function ResultListController($scope, Result) {
    $scope.results = Story.query();
    
}

function ResultListController($scope, $routeParams, $location, Result) {
    var subject = $routeParams.subject;
    
    $scope.results = Result.get({subject: subject});

}

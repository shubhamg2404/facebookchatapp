(function(){


//NOT OF ANY USE AS IF FOR NOW
  var app = angular.module('myapp');


  var homeController = function($scope,server,chat){


    chat.setUsername('username');

    $scope.send = function(){
      chat.sendMessage($scope.chatInput);
    }
  }
  app.controller('homeController',homeController);


}())

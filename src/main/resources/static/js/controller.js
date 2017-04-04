app
    .controller(
        'tablesController',
        function($scope, $resource, $http) {

        	$('.dateSelection').hide();
        	$('.comparisonChart').hide();
        	this.myDate = new Date();
            this.isOpen = false;
            $scope.tableList = $resource('getAllCities').query();
            $scope.hotelList = '';
                
            
            $scope.validCheckOutDate = function() {
            	
                $scope.minDate = new Date($scope.checkInDate.getFullYear(),
						$scope.checkInDate.getMonth(), $scope.checkInDate
								.getDate() + 1);
            
            };
            	
            var data = {
               
            		
            	"xData": ["22April2017","23April2017", "24April2017","25April2017"],
                
                
                "yData": [{
                        "name": "Tokyo",
                        "data": [500, 600, 669.5, 690]
                    },
                    {
                        "name": "London",
                        "data": [800, 420, 800, 825]
                    }
                ]
            };

            $scope.lineChartYData = data.yData;
            $scope.lineChartXData = data.xData;

       
            
            $scope.fetchCityHotels = function() {
                $http
                    .get("http://developer.goibibo.com/api/cyclone/?app_id=4663135e&app_key=73a217a9461375e465dd4be077800f32&city_id="+$scope.selected.cityId)
                    .success(function(posts) {
                        $scope.hotelList = posts.data;
                    	$('.dateSelection').show();
                    	$('.comparisonChart').show();
                    });

            };

            $scope.fetchHotelPriceDetails = function() {
            	
            	var checkInMonth='';
            	if($scope.checkInDate.getMonth()>9){
            		checkInMonth= $scope.checkInDate.getMonth()+1;
            	}else{
            		checkInMonth=$scope.checkOutDate.getMonth()+1;
            		checkInMonth="0"+checkInMonth+"";
            	}
            	var next5DatesToSearch=[];
            	
            	 for (var i=1; i<5; i++) {
            		 
            		 var d1= new Date($scope.checkInDate.getFullYear(),
     						$scope.checkInDate.getMonth(), $scope.checkInDate
     								.getDate() + i);
            		 
            		 var d2= new Date($scope.checkOutDate.getFullYear(),
      						$scope.checkOutDate.getMonth(), $scope.checkOutDate
								.getDate() + i);
            		 
            		var d1= ""+d1.getFullYear()+""+checkInMonth+""+d1.getDate()+""
            		 var d2=""+d2.getFullYear()+""+checkInMonth+""+d2.getDate()+""
            		next5DatesToSearch.push(d1);
            		next5DatesToSearch.push(d2);
            	  }
            	 
            	
            	
            			
            	var params = {
            			 cityId :$scope.selected.cityId,
            			 checkInDate:""+$scope.checkInDate.getFullYear()+""+checkInMonth+""+$scope.checkInDate.getDate()+"",  
            			 checkOutDate:""+$scope.checkOutDate.getFullYear()+""+checkInMonth+""+$scope.checkOutDate.getDate()+"",
            			 next5Dates : next5DatesToSearch
            		};
            	
            	$http({
            	    method: 'GET',
            	    url: 'getPriceDetails',
            	    params: params})
                 .success(function(posts) {
                	 
                     $scope.hotelList = posts.data;
                     
                 });
            };

        });
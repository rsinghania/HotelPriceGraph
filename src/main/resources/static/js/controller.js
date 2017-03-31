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
                    .get(
                        "http://developer.goibibo.com/api/cyclone/?app_id=4663135e&app_key=73a217a9461375e465dd4be077800f32&city_id="+$scope.selected.cityId+"&check_in=20170422&check_out=20170423")
                    .success(function(posts) {
                        $scope.hotelList = posts.data;
                    	$('.dateSelection').show();
                    	$('.comparisonChart').show();
                    });

            };

            $scope.fetchHotelDetails = function() {
                $scope.hotelDetail = $resource(
                    "http://developer.goibibo.com/api/voyager/?app_id=4663135e&app_key=73a217a9461375e465dd4be077800f32&method=hotels.get_hotels_data&id_list=[" +
                    this.item.hotel_data_node._id +
                    "]&id_type=_id").query();
            };

            $scope.fetchHotelPriceDetails = function() {
            	$scope.hotelPriceDetails = $resource("http://developer.goibibo.com/api/cyclone/?app_id=4663135e&app_key=73a217a9461375e465dd4be077800f32&city_id="+$scope.selected.cityId+"&check_in=20170423&check_out=20170423"
            };

        });
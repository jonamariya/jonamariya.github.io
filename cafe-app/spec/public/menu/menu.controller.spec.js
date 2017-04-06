describe('The MenuController', function() {
  'use strict';

  var menuController;
  var menuCategories = [
    {"id":81,"short_name":"B","name":"Breakfast","special_instructions":"Breakfast Served 8:30am - 11:30am","url":"categories/81.json"},
	{"id":82,"short_name":"L","name":"Lunch","special_instructions":"Lunch Available from 11:30am - 2:00pm","url":"categories/82.json"},
	{"id":83,"short_name":"S","name":"Salad Bowls","special_instructions":"","url":"categories/83.json"},
	{"id":84,"short_name":"BR","name":"Burgers","special_instructions":"","url":"categories/84.json"},
	{"id":85,"short_name":"HD","name":"Hot Drinks","special_instructions":"","url":"categories/85.json"},
	{"id":86,"short_name":"CD","name":"Cold Drinks","special_instructions":"","url":"categories/86.json"}
  ];

  /**
   * Gets called before each unit test it()
   */
  beforeEach(function() {
    // Load module
    module('public');

    // Load any dependencies
    inject(function ($injector) {
      var $controller = $injector.get('$controller');
      var $log = $injector.get('$log');

      // Instantiate controller
      menuController = $controller('MenuController', {
        $log: $log,
        menuCategories: menuCategories
      });
    });
  });

  it('should initialize with menu categories', function() {
    expect(menuController).toBeDefined();
    expect(menuController.menuCategories).toEqual(menuCategories);
  });



});
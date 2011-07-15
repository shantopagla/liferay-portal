AUI().add(
	'liferay-history',
	function(A) {
		var Lang = A.Lang;

		var AObject = A.Object;

		var QueryString = A.QueryString;

		var isValue = Lang.isValue;

		var owns = AObject.owns;

		var WIN = A.config.win;

		var LOCATION = WIN.location;

		var History = A.Component.create(
			{
				EXTENDS: A.History,

				NAME: 'liferayhistory',

				prototype: {
					get: function(key) {
						var instance = this;

						var value = History.superclass.get.apply(this, arguments);

						if (!isValue(value) && isValue(key)) {
							var query = LOCATION.search;

							var queryMap = instance._parse(query.substr(1));

							if (owns(queryMap, key)) {
								value = queryMap[key];
							}
						}

						return value;
					},

					_parse: A.cached(
						function(str) {
							return QueryString.parse(str);
						}
					)
				}
			}
		);

		Liferay.History = History;
	},
	'',
	{
		requires: ['querystring-parse-simple']
	}
);
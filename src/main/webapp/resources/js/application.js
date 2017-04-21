
function updateBuilds(){
	jQuery.getJSON('builds', {
		projectId : jQuery('#project').val(),
		ajax : 'true'
	}, function(data) {
		var html = '<option value="" selected="selected" disabled>Select the build</option>';
		var len = data.length;
		for ( var i = 0; i < len; i++) {
			html += '<option value="' + data[i].id + '">'
					+ data[i].name + '</option>';
		}
		html += '</option>';

		jQuery('#build').html(html);
	});
}

jQuery(document).ready(
		function() {
			jQuery.getJSON('builds', {
				projectId : jQuery('#project').val(),
				ajax : 'true'
			}, function(data) {
				var buildId = jQuery('#build').val();
				var html = '<option value="" selected="selected" disabled>Select the build</option>';
				var len = data.length;
				for ( var i = 0; i < len; i++) {
					if(buildId == data[i].id){
						html += '<option selected="selected" value="' + data[i].id + '">'
						+ data[i].name + '</option>';						
					}else{
						html += '<option value="' + data[i].id + '">'
						+ data[i].name + '</option>';	
					}
				}
				html += '</option>';
				jQuery('#build').html(html);
			});
		});
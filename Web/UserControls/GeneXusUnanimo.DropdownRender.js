function GeneXusUnanimo_Dropdown(n){var t,r,u,f,e,i;this.setDropdownItems=function(n){this.DropdownItems=n};this.getDropdownItems=function(){return this.DropdownItems};t='<div class="dropdown">\t<div class="dd-flex-container">\t\t<div class="dd-vertical-separator" id="ddSeparator"><\/div>\t\t<div class="dd-text-container" id="textContainer">\t\t\t<div class="row"> <span class="dd-username">{{UserFullName}}<\/span> <\/div>\t\t\t<div class="row"> <span class="dd-companyname">{{UserCompany}}<\/span> <\/div>\t\t<\/div>\t\t<div class="dd-avatar-container" id="imgContainer">\t\t\t<img {{#UserPhoto}}src={{UserPhoto}}{{/UserPhoto}} class="dd-avatar" alt="avatar-image">\t\t<\/div>\t<\/div> \t<div class="dropdown-content">\t\t{{#DropdownItems}}\t\t<a id="{{id}}" class="dd-option-container" href="#">\t\t\t<img alt="{{alternativeText}}" class="dd-option-icon" src={{icon}}>\t\t\t<span class="dd-option">{{title}}<\/span>\t\t<\/a>\t\t{{/DropdownItems}}\t\t{{#ShowLogoutOption}}\t\t<!-- default logout event -->\t\t<a class="dd-option-container"  data-event="Logout" >\t\t\t<img alt="logout_icon" class="dd-option-icon" src={{LogoutIcon}}>\t\t\t<span class="dd-option">Logout<\/span>\t\t<\/a>\t\t{{/ShowLogoutOption}}\t<\/div><\/div>';r={};Mustache.parse(t);u=0;f=0;this.show=function(){e=n(this.getContainerControl());u=0;f=0;this.setHtml(Mustache.render(t,this,r));this.renderChildContainers();n(this.getContainerControl()).find("[data-event='Logout']").on("click",this.onLogoutHandler.closure(this)).each(function(n){this.setAttribute("data-items-index",n+1)});n(this.getContainerControl()).find("[data-event='ItemClick']").on("itemclick",this.onItemClickHandler.closure(this)).each(function(n){this.setAttribute("data-items-index",n+1)});this.Init()};this.Scripts=[];this.Init=function(){const t=this,i=n("#imgContainer"),r=n("#textContainer"),e=n("#ddSeparator");switch(t.DisplayType){case"Avatar":r[0].hidden=!0;break;case"Text":i[0].hidden=!0}const u=document.getElementsByClassName("dropdown-content")[0];u.addEventListener("click",function(n){var i=f(n.target);if(i!==null)for(let n=0;n<t.DropdownItems.length;n++){const r=t.DropdownItems[n];if(r.id===i.id){t.SelectedItemId=r.id;t.SelectedItemTarget=r.link;t.ItemClick();break}}});var f=function(n){while(n!==null){if(n.tagName&&n.tagName.toUpperCase()==="A")return n;n=n.parentNode}return null}};this.onLogoutHandler=function(t){if(t){var i=t.currentTarget;t.preventDefault();this.DropdownItemsCurrentIndex=parseInt(n(i).attr("data-items-index"),10)||1}this.Logout&&this.Logout()};this.onItemClickHandler=function(t){if(t){var i=t.currentTarget;t.preventDefault();this.DropdownItemsCurrentIndex=parseInt(n(i).attr("data-items-index"),10)||1}this.ItemClick&&this.ItemClick()};this.autoToggleVisibility=!0;i={};this.renderChildContainers=function(){e.find("[data-slot][data-parent='"+this.ContainerName+"']").each(function(t,r){var e=n(r),f=e.attr("data-slot"),u;u=i[f];u||(u=this.getChildContainer(f),i[f]=u,u.parentNode.removeChild(u));e.append(u);n(u).show()}.closure(this))}}
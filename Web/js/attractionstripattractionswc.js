gx.evt.autoSkip=!1;gx.define("attractionstripattractionswc",!0,function(n){var t,i;this.ServerClass="attractionstripattractionswc";this.PackageName="com.kbbaru";this.ServerFullClass="com.kbbaru.attractionstripattractionswc";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.anyGridBaseTable=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="KBBaru";this.SetStandaloneVars=function(){this.AV6AttractionsId=gx.fn.getIntegerValue("vATTRACTIONSID",",");this.AV6AttractionsId=gx.fn.getIntegerValue("vATTRACTIONSID",",")};this.Valid_Tripid=function(){var n=gx.fn.currentGridRowImpl(15);return this.validCliEvt("Valid_Tripid",15,function(){try{if(gx.fn.currentGridRowImpl(15)===0)return!0;var n=gx.util.balloon.getNew("TRIPID",gx.fn.currentGridRowImpl(15));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e131z2_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e141z2_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,10,11,12,13,14,16,17,18,19,20,21,22];this.GXLastCtrlId=22;this.GridContainer=new gx.grid.grid(this,2,"WbpLvl2",15,"Grid","Grid","GridContainer",this.CmpContext,this.IsMasterPage,"attractionstripattractionswc",[],!1,1,!1,!0,0,!0,!1,!1,"",0,"px",0,"px","New row",!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);i=this.GridContainer;i.addSingleLineEdit(18,16,"TRIPID","Id","","TripId","int",0,"px",4,4,"right",null,[],18,"TripId",!0,0,!1,!1,"Attribute",0,"column WWOptionalColumn");i.addSingleLineEdit(19,17,"TRIPDATE","Date","","TripDate","date",0,"px",8,8,"right",null,[],19,"TripDate",!0,0,!1,!1,"attribute-description",0,"column");i.addSingleLineEdit(20,18,"TRIPDESCRIPTION","Description","","TripDescription","svchar",0,"px",200,80,"left",null,[],20,"TripDescription",!0,0,!1,!1,"Attribute",0,"column WWOptionalColumn");this.GridContainer.emptyText="";this.setGrid(i);t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"MAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"GRIDCELL",grid:0};t[6]={id:6,fld:"GRIDTABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"GRIDCONTAINER",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,fld:"",grid:0};t[16]={id:16,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:15,gxgrid:this.GridContainer,fnc:this.Valid_Tripid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TRIPID",fmt:0,gxz:"Z18TripId",gxold:"O18TripId",gxvar:"A18TripId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A18TripId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z18TripId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("TRIPID",n||gx.fn.currentGridRowImpl(15),gx.O.A18TripId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A18TripId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("TRIPID",n||gx.fn.currentGridRowImpl(15),",")},nac:gx.falseFn};t[17]={id:17,lvl:2,type:"date",len:8,dec:0,sign:!1,ro:1,isacc:0,grid:15,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TRIPDATE",fmt:0,gxz:"Z19TripDate",gxold:"O19TripDate",gxvar:"A19TripDate",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A19TripDate=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z19TripDate=gx.fn.toDatetimeValue(n))},v2c:function(n){gx.fn.setGridControlValue("TRIPDATE",n||gx.fn.currentGridRowImpl(15),gx.O.A19TripDate,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A19TripDate=gx.fn.toDatetimeValue(this.val(n)))},val:function(n){return gx.fn.getGridDateTimeValue("TRIPDATE",n||gx.fn.currentGridRowImpl(15))},nac:gx.falseFn};t[18]={id:18,lvl:2,type:"svchar",len:200,dec:0,sign:!1,ro:1,isacc:0,grid:15,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TRIPDESCRIPTION",fmt:0,gxz:"Z20TripDescription",gxold:"O20TripDescription",gxvar:"A20TripDescription",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A20TripDescription=n)},v2z:function(n){n!==undefined&&(gx.O.Z20TripDescription=n)},v2c:function(n){gx.fn.setGridControlValue("TRIPDESCRIPTION",n||gx.fn.currentGridRowImpl(15),gx.O.A20TripDescription,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A20TripDescription=this.val(n))},val:function(n){return gx.fn.getGridControlValue("TRIPDESCRIPTION",n||gx.fn.currentGridRowImpl(15))},nac:gx.falseFn};t[19]={id:19,fld:"",grid:0};t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ATTRACTIONSID",fmt:0,gxz:"Z9AttractionsId",gxold:"O9AttractionsId",gxvar:"A9AttractionsId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A9AttractionsId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z9AttractionsId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("ATTRACTIONSID",gx.O.A9AttractionsId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A9AttractionsId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("ATTRACTIONSID",",")},nac:gx.falseFn};this.declareDomainHdlr(22,function(){});this.Z18TripId=0;this.O18TripId=0;this.Z19TripDate=gx.date.nullDate();this.O19TripDate=gx.date.nullDate();this.Z20TripDescription="";this.O20TripDescription="";this.A9AttractionsId=0;this.Z9AttractionsId=0;this.O9AttractionsId=0;this.A9AttractionsId=0;this.AV6AttractionsId=0;this.A18TripId=0;this.A19TripDate=gx.date.nullDate();this.A20TripDescription="";this.Events={e131z2_client:["ENTER",!0],e141z2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV6AttractionsId",fld:"vATTRACTIONSID",pic:"ZZZ9"},{av:"sPrefix"}],[]];this.EvtParms["GRID.LOAD"]=[[],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.GRID_FIRSTPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV6AttractionsId",fld:"vATTRACTIONSID",pic:"ZZZ9"},{av:"sPrefix"}],[]];this.EvtParms.GRID_PREVPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV6AttractionsId",fld:"vATTRACTIONSID",pic:"ZZZ9"},{av:"sPrefix"}],[]];this.EvtParms.GRID_NEXTPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV6AttractionsId",fld:"vATTRACTIONSID",pic:"ZZZ9"},{av:"sPrefix"}],[]];this.EvtParms.GRID_LASTPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV6AttractionsId",fld:"vATTRACTIONSID",pic:"ZZZ9"},{av:"sPrefix"}],[]];this.EvtParms.VALID_TRIPID=[[],[]];this.setVCMap("AV6AttractionsId","vATTRACTIONSID",0,"int",4,0);this.setVCMap("AV6AttractionsId","vATTRACTIONSID",0,"int",4,0);this.setVCMap("AV6AttractionsId","vATTRACTIONSID",0,"int",4,0);i.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid"});i.addRefreshingVar({rfrVar:"AV6AttractionsId"});i.addRefreshingParm({rfrVar:"AV6AttractionsId"});this.Initialize()})
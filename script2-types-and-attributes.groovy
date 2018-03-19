  import de.hybris.platform.core.model.type.*;
  import java.lang.String;
  type_to_export=[
   // =============== REPLACE THE LIST OF TYPES WITH YOUR OWN ====
   // =============== SOME TYPES MAY NEED TO BE COMMENTED OUT ====
   // =============== BECAUSE OF THEY ARE EMPTY, NOT USED OR  ====
   // =============== NOT IMPORTANT FOR COPYING ==================
   //"MediaContainer",
   "Product",
   "VariantProduct",
   "GenericVariantProduct",
   "ApparelStyleVariantProduct",
   "ApparelSizeVariantProduct",
   "ElectronicsColorVariantProduct",
   "ApparelProduct",
   //"Media",
   //"Formatter",
   //"ItemFormatter",
   //"CustomOrder2XML",
   //"VelocityFormatter",
   //"MediaFormatter",
   //"FOPFormatter",
   //"XMLTransformFormatter",
   //"Document",
   //"JobMedia",
   //"LogFile",
   //"ImpExMedia",
   //"HeaderLibrary",
   //"ImpExExportMedia",
   //"CatalogVersionSyncScheduleMedia",
   //"BarcodeMedia",
   //"JasperMedia",
   //"CompiledJasperMedia",
   //"EmailAttachment",
   //"CxAbstractAction",
   //"CxCmsAction",
   //"CxSearchProfileAction",
   //"CxPromotionAction",
   //"CxVariation",
   //"AbstractConfiguratorSetting",
   //"TextFieldConfiguratorSetting",
   "Keyword",
   "ClassificationKeyword",
   "Category",
   "ConfigurationCategory",
   "ClassificationClass",
   "VariantCategory",
   "VariantValueCategory",
   "ClassificationAttributeUnit",
   "ClassAttributeAssignment",
   "ClassificationAttribute",
   "ClassificationAttributeValue",
   "AttributeValueAssignment",
   //"DiscountRow",
   //"PriceRow",
   //"TaxRow",
   //"CxCustomization",
   //"CxCustomizationsGroup",
   //"CxAbstractTrigger",
   //"CxSegmentTrigger",
   //"CxExpressionTrigger",
   //"CxDefaultTrigger",
   //"CMSItem",
   //"AbstractPage",
   "ContentPage",
   "CategoryPage",
   "ProductPage",
   "CatalogPage",
   "DocumentPage",
   "EmailPage",
   "ContentSlot",
   //"AbstractCMSComponent",
   //"AbstractCMSComponentContainer",
   "ABTestCMSComponentContainer",
   "CMSTabParagraphContainer",
   //"CxCmsComponentContainer",
   "SimpleCMSComponent",
   "CMSParagraphComponent",
   "CMSTabParagraphComponent",
   "AssistedServiceComponent",
   "CMSImageComponent",
   "CMSLinkComponent",
   "AbstractBannerComponent",
   "BannerComponent",
   "FlashComponent",
   "ImageMapComponent",
   "DynamicBannerComponent",
   "SimpleBannerComponent",
   "ProductCarouselComponent",
   "RotatingImagesComponent",
   "ProductListComponent",
   "ProductDetailComponent",
   "ProductReferencesComponent",
   "SimpleSuggestionComponent",
   "PurchasedCategorySuggestionComponent",
   "CartSuggestionComponent",
   "MiniCartComponent",
   "NavigationBarComponent",
   "NavigationBarCollectionComponent",
   "NavigationComponent",
   "CategoryNavigationComponent",
   "FooterNavigationComponent",
   "FooterComponent",
   "ProductFeatureComponent",
   "CategoryFeatureComponent",
   "SubCategoryListComponent",
   "ProductVariantSelectorComponent",
   "ProductAddToCartComponent",
   "SearchBoxComponent",
   "AccountNavigationComponent",
   "AccountNavigationCollectionComponent",
   "JspIncludeComponent",
   "BreadcrumbComponent",
   "LanguageCurrencyComponent",
   "LogoComponent",
   "StoreFinderComponent",
   "AccountControlComponent",
   "ProductRefinementComponent",
   "CMSProductListComponent",
   "ProductGridComponent",
   "SearchResultsListComponent",
   "SearchResultsGridComponent",
   "AccountBookmarkComponent",
   "AbstractMediaContainerComponent",
   "AbstractResponsiveBannerComponent",
   "SimpleResponsiveBannerComponent",
   "AbstractCMSAction",
   "SimpleCMSAction",
   "AddToCartAction",
   "ListAddToCartAction",
   "ListAddToEntryGroupAction",
   "ListOrderFormAction",
   "ListPickUpInStoreAction",
   "PickUpInStoreAction",
   "ShareOnSocialNetworkAction",
   "ViewOrderAction",
   "ViewStoreAction",
   "CancelOrderAction",
   "ReturnOrderAction",
   "CancelReturnAction",
   "AsmDevicesUsedComponent",
   "AsmFavoriteColorsComponent",
   "CMSNavigationNode",
   "PageTemplate",
   "DocumentPageTemplate",
   "EmailPageTemplate",
   "CMSNavigationEntry",
   "CMSRelation",
   "ContentSlotForTemplate",
   "ContentSlotForPage",
   //"AbstractAsSearchProfile",
   //"AsSimpleSearchProfile",
   //"AsCategoryAwareSearchProfile",
   //"AsSearchProfileActivationSet",
   //"AbstractAsSearchConfiguration",
   //"AbstractAsConfigurableSearchConfiguration",
   //"AsSimpleSearchConfiguration",
   //"AsCategoryAwareSearchConfiguration",
   //"AbstractAsItemConfiguration",
   //"AbstractAsFacetConfiguration",
   //"AsPromotedFacet",
   //"AsFacet",
   //"AsExcludedFacet",
   //"AbstractAsBoostItemConfiguration",
   //"AsPromotedItem",
   //"AsExcludedItem",
   //"AbstractAsBoostRuleConfiguration",
   //"AsBoostRule"
  ];

  // THE ATTRIBUTES BELOW ARE EXCLUDED FROM THE PROCESSING
  // WITH TYPES SPECIFIED (type.attribute)
  blacklistedObjAttrs = [
  'ContentPage.contentSlots',
  'CategoryPage.contentSlots',
  'ProductPage.contentSlots',
  'CatalogPage.contentSlots',
  'DocumentPage.contentSlots',
  'EmailPage.contentSlots',
  'PageTemplate.contentSlots',
  'DocumentPageTemplate.contentSlots',
  'EmailPageTemplate.contentSlots',
  'ContentSlot.cmsComponents'
  ];
  // WITHOUT TYPES SPECIFIED (for all types)
  blacklistedattrs = [
  'availableContentSlots',
  'missingContentSlots',
  'allDocuments',
  'assignedCockpitItemTemplates',
  'comments',
  'creationtime',
  'itemtype',
  'modifiedtime',  
  'owner',
  'synchronizationSources',
  'synchronizedCopies',
  'savedValues' ];
  SEPARATOR = ";";
  ComposedTypeModel getComposedTypeForAttr(attr){
     attrComposedType = null;
      try { 
       attrComposedType  = typeService.getComposedTypeForCode(attr);
       if (attrComposedType) 
        { catalogAware = attrComposedType.getCatalogItemType(); }
       } catch (Exception e) { }
      return attrComposedType; 
  }

  java.lang.String buildImpexString(type, objectsScanned){
    def typeObj = typeService.getComposedTypeForCode(type);
    def attrs = typeService.getAttributeDescriptorsForType(typeObj);    
    def str = "(";
    def attributeTypeCode = "";
    def attributeType = null;
    def attrComposedType = null;
    if (objectsScanned.contains(type)) { return ""; } 
    objectsScanned.add(type);
    def uniqueFields = [];
    for (attr in attrs) {
      if (attr.getUnique()) { 
         attributeType= attr.getAttributeType();
         attributeTypeCode = attributeType.getCode();
         attributeTypeCode = attributeTypeCode.replace("localized:","");
        if (blacklistedattrs.contains(attr.getQualifier()) || blacklistedObjAttrs.contains(type + "." + attr.getQualifier())) { continue; }
         uniqueFields.add(attr); 
         if (str != "(") { str = str + ", "; }
         str = str + attr.getQualifier();

         attrComposedType=getComposedTypeForAttr(attributeTypeCode);
         if (attrComposedType) { 
          str = str  + buildImpexString(attrComposedType.getCode(), objectsScanned); 
         }
      }
    }  
    if (str != '(') {
    str = str + ")";
     } else { str = "   "; }
    return str ; 
  }

  void export_type_def(type){
    typeObj = typeService.getComposedTypeForCode(type);
    attrs = typeService.getAttributeDescriptorsForType(typeObj);

    for (attr in attrs) {
       qualifier    = attr.getQualifier();
       if (blacklistedattrs.contains(qualifier) || blacklistedObjAttrs.contains(type + "." + attr.getQualifier())) { continue; }
       attributeType= attr.getAttributeType();
       unique       = attr.getUnique();
       writeable    = attr.getWritable();
       partOf       = attr.getPartOf();       
       attributeTypeCode = attributeType.getCode();
       attributeTypeCode = attributeTypeCode.replace("localized:","");
       collection   = attributeType instanceof CollectionTypeModel;
       relation     = attr.getItemtype() == "RelationDescriptor";
       (relationType, relationSourceAttr, relationTargetAttr, relationSourceAttrType, relationTargetAttrType, relationSourceAttrTypeRole, relationTargetAttrTypeRole) =
       [null,         null,               null,               null,                   null,                   null,                       null]
       // relationType = null;
       // relationSourceAttr = null;
       // relationTargetAttr = null; 
       // relationSourceAttrType = null;
       // relationTargetAttrType = null;
       // relationSourceAttrTypeRole = null;
       // relationTargetAttrTypeRole = null;
       isSource = null;
       impexStr = "";
       if (collection) 
         {
            collectionElementType    = ((CollectionTypeModel) attributeType).getElementType();
            collectionElementTypeCode = collectionElementType.getCode();
            if (collectionElementType instanceof ComposedTypeModel)
              impexStr = buildImpexString(collectionElementTypeCode, []);
         }
       if (relation) {
          relationQualifier = ((RelationDescriptorModel) attr).getQualifier();
          relationSourceAttr=  ((RelationDescriptorModel) attr).getRelationType().getSourceAttribute()?.getQualifier();
          relationTargetAttr=  ((RelationDescriptorModel) attr).getRelationType().getTargetAttribute()?.getQualifier();
          relationSourceAttrType=  ((RelationDescriptorModel) attr).getRelationType().getSourceType().getCode();
          relationTargetAttrType=  ((RelationDescriptorModel) attr).getRelationType().getTargetType().getCode();

          isSource=  ((RelationDescriptorModel) attr).getIsSource();  
          //if (!partOf) {
            if (!isSource ) {           
              impexStr = buildImpexString(relationSourceAttrType, []);
            } else
            {
              impexStr = buildImpexString(relationTargetAttrType, []);
            }
          //}
          
          relationSourceAttrTypeRole=  ((RelationDescriptorModel) attr).getRelationType().getSourceTypeRole();
          relationTargetAttrTypeRole=  ((RelationDescriptorModel) attr).getRelationType().getTargetTypeRole();  
          
       } 
       
       catalogAware = false; 
       attrComposedType = getComposedTypeForAttr(attributeTypeCode);
       if (attrComposedType 
        //&& !partOf
        ) {
                impexStr = buildImpexString(attrComposedType.getCode(), []);
       }
       enumeration = attr.getAttributeType() instanceof de.hybris.platform.core.model.enumeration.EnumerationMetaTypeModel;
       if (enumeration 
        //&& !partOf
        ) 
       {
          impexStr = "(code)";
       } 
       localized    = attr.getLocalized();
       mandatory    = !attr.getOptional();
       relationPart = SEPARATOR+        
         (relationSourceAttr)+SEPARATOR+
         (relationTargetAttr)+SEPARATOR+
         (relationSourceAttrType)+SEPARATOR+
         (relationTargetAttrType)+SEPARATOR+
         (relationSourceAttrTypeRole)+SEPARATOR+
         (relationTargetAttrTypeRole);
       print "\""+type+SEPARATOR+
         qualifier+SEPARATOR+
         attributeTypeCode+SEPARATOR+
         (impexStr)+SEPARATOR+
         (unique?1:0)+SEPARATOR+
         (localized?1:0)+SEPARATOR+
         (mandatory?1:0)+SEPARATOR+
         (writeable?1:0)+SEPARATOR+         
         (partOf?1:0)+SEPARATOR+
         (enumeration?1:0) + SEPARATOR +
         (isSource)+
         //relationPart
         "\",";         
       print "\n";
    }
  }

  print "type"+SEPARATOR+"qualifier"+SEPARATOR+"attributeType"+SEPARATOR+"impexStr"+SEPARATOR+"unique?"+SEPARATOR+"localized?"+SEPARATOR+"mandatory?\n";
  for (type in type_to_export) {
    export_type_def(type);
  }
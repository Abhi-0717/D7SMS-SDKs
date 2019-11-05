//
//  D7SMS
//
//
#import <Foundation/Foundation.h>
#import "APIHelper.h"
#import "NSDate+extension.h"


@interface TestHelper : NSObject

/**
     * Recursively check whether the leftTree is a proper subset of the right tree
     * @param leftTree Left tree
     * @param rightTree Right tree
     * @param checkValues Check primitive values for equality?
     * @param allowExtra Are extra elements allowed in right array?
     * @param isOrdered Should elements in right be compared in order to left?
     * @return
*/
+(BOOL) isProperSubsetOf: (NSDictionary*) leftTree
               rightTree:(NSDictionary*) rightTree
            checkValues: (BOOL) checkValues
              allowExtra: (BOOL) allowExtra
               isOrdered: (BOOL) isOrdered;

/**
    * Recursively check whether the left JSON object is a proper subset of the right JSON object
    * @param leftObject Left JSON object as string
    * @param rightObject Right JSON object as string
    * @param checkValues Check primitive values for equality? 
    * @return True if its a subset
*/
+(BOOL) isJsonObjectProperSubsetOf: (NSString*) leftObject
                       rightObject: (NSString*) rightObject
                       checkValues: (BOOL) checkValues
                        allowExtra:(BOOL) allowExtra
                         isOrdered: (BOOL) isOrdered;

/**
    * Check if left array of objects is a subset of right array
    * @param leftObject Left array as a JSON string
    * @param rightObject Right array as a JSON string
    * @param checkValues Check primitive values for equality?
    * @param allowExtra Are extra elements allowed in right array?
    * @param isOrdered Should elements in right be compared in order to left?
    * @return True if it is a subset
*/
+(BOOL) isArrayOfJsonObjectsProperSubsetOf: (NSString*) leftObject
                               rightObject: (NSString*) rightObject
                               checkValues: (BOOL) checkValues
                                allowExtra:(BOOL) allowExtra
                                 isOrdered: (BOOL) isOrdered;

/**
     * Check if left array of objects is a subset of right array
     * @param left Left array as a NSArray
     * @param right Right array as a NSArray
     * @param checkValues Check primitive values for equality?
     * @param allowExtra Are extra elements allowed in right array?
     * @param isOrdered Should elements in right be compared in order to left?
     * @return True if it is a subset
*/
+(BOOL) isArrayOfJsonObjectsProperSubsetOf: (NSArray<NSDictionary*>*) left
                                     right: (NSArray<NSDictionary*>*) right
                               checkValues: (BOOL) checkValues
                                allowExtra:(BOOL) allowExtra
                                 isOrdered: (BOOL) isOrdered;

/**
     * Check whether the a list is a subset of another list
     * @param leftList Expected List
     * @param rightList List to check
     * @param allowExtra Are extras allowed in the list to check?
     * @param isOrdered Should checking be in order?
     * @return true if its a subset
*/
+(BOOL) isListProperSubsetOf: (NSArray*) leftList
                   rightList:(NSArray*) rightList
                  allowExtra: (BOOL) allowExtra
                   isOrdered: (BOOL) isOrdered;

@end
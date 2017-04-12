typedef int bool;

#define TRUE 1
#define FALSE 0

#define UNKNOWN 0
#define FIELD 1
#define BUTTON 2

#define NONE 0
#define FLOAT_t 1
#define INTEGER_t 2
#define STRING_t 3

typedef struct ListItem{
   struct ListItem * next;
   char* name; /* top and bottom portions use name */
   char* value; /* bottom portion uses value */
   bool verified;
   int parType; /* field or button */
   int valType; /* variable type (STRING/INTEGER/BOOL etc) */
}ListItem;

ListItem* createTracker(void);
ListItem* createItem(char*,char*,int);
void addItem(ListItem*,char*,char*,int);
void printList(ListItem*);

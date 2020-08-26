**Quick start with App Center Test**

 1. Create a new test application on **Android** or **iOS** with some view elements (text views, lists, fragments etc) or use ready test application. 

*NOTE: If you use ready test app you can skip step 2.*
 
 2. Follow this [guide](https://docs.microsoft.com/en-us/appcenter/sdk/getting-started/android#2-create-your-app-in-the-app-center-portal-to-obtain-the-app-secret) for integrate the `App Center`.
 3. Open on the `App Center` portal you application and select `Test` button on the left side.
 4. Select `Start testing your app` button on the center page or `New test run` on the top right corner. 
 5. Select devices in the list.
 6. Select branch, system language and test framework.
 7. Follow by instruction about installing `appcenter-cli` and uploading apk file.

*NOTE: Make sure that you use node version `6.3` or later (recommend node version [10.18.0](https://nodejs.org/en/blog/release/v10.18.0/)).*

*NOTE: Make sure that you perfume `appcenter login` after installing `appcenter-cli`.*

The build result you can see on the `Test` page on the portal or in console logs.
